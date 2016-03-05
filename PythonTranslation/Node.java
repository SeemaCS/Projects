import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.xml.crypto.Data;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Node {

	int id;
	boolean isRunning = true;
	int port;
	int udpPort;
	String ipAddress;
	int leaderId = -1;
	boolean terminate = false;
	boolean isNode = true;
	//Logger logger;
	Acceptor acceptor;
	Proposer proposer;
	HashMap<Integer, Node> peers = new HashMap<Integer, Node>();
	
	HashMap<Integer, Calendar> log = new HashMap<Integer, Calendar>();
	
	Calendar calendar = null;

	public Node(int id) {
		this.id = id;
		this.calendar = new Calendar();
		this.acceptor = new Acceptor(this);
		this.proposer = new Proposer(this);
		//logger = new MyLogger(this).LOGGER;
		
	}

	public void loadIpTable() {
		File dir = new File(".");
		File ipFile;
		try {
			ipFile = new File(dir.getCanonicalPath() + File.separator + "ipPortTable.txt");
			BufferedReader br = new BufferedReader(new FileReader(ipFile));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(",");
				int nodeId = Integer.parseInt(tokens[0]);
				if(this.id == nodeId) {
					port = Integer.parseInt(tokens[2]);
					ipAddress = tokens[1];
					udpPort = Integer.parseInt(tokens[3]);
				}
				else {
					Node n = new Node(nodeId);
					n.port = Integer.parseInt(tokens[2]);
					n.ipAddress = tokens[1];
					n.udpPort = Integer.parseInt(tokens[3]);
					this.peers.put(n.id, n);
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void terminate() {
		this.terminate = true;
		
		// Send special termination message to itself
		DatagramSocket socket;
		try {
			InetSocketAddress addr = new InetSocketAddress(this.udpPort);
			socket = new DatagramSocket(null);
			socket.setReuseAddress(true);
			socket.setBroadcast(true);
			socket.bind(addr);
			UDPMessage msgObj = new UDPMessage("terminate", -1, null, -1, this.id);
			msgObj.print();
			byte[] buf = new byte[4096];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(msgObj);
			oos.flush();
			byte[] data = baos.toByteArray();
			InetAddress add = InetAddress.getByName("localhost");
			DatagramPacket packet = new DatagramPacket(data, data.length, add, this.udpPort);
			socket.send(packet);
			socket.close();
			
			Thread.sleep(1000);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void parseCommand(String input) {
		String[] tokens = input.split(" ");
		if(tokens[0].equals("schedule")) {
			System.out.println("Scheduling appointment...");
			
			Appointment appointment = parseAppointment(tokens);
			this.insertAppointment(appointment);
		}
	}
	
	public Appointment parseAppointment(String[] tokens) {
		Appointment appointment = null;
		
		String name = tokens[1];
	
		String participants = tokens[2];
		participants = participants.substring(1, participants.length()-1);
		String[] users = participants.split(",");
		List<Integer> userList = new ArrayList<Integer>();
		for(String u : users) {
			u = u.substring(4, u.length());
			userList.add(Integer.parseInt(u));
		}
		
		String time = tokens[3];
		time = time.substring(1, time.length()-1);
		String[] times = time.split(",");
		String startTime = times[0];
		String endTime = times[1];
		
		String day = tokens[4];
	
		appointment = new Appointment(name, day, startTime, endTime, userList);
		
		return appointment;
	}
	
	public void insertAppointment(Appointment appointment) {
		
		Calendar newCalendar = new Calendar(this.calendar);
		newCalendar.appointments.add(appointment);
		
		int nextLogSlot = -1;
		//Logic for log keys
		if(!this.log.isEmpty()) {
			nextLogSlot = Collections.max(this.log.keySet()) + 1;
		} else {
			nextLogSlot = 0;
		}
		
		//Get leader
		int leaderId = this.leaderId;
		Node leader;
		if(leaderId == this.id) {
			leader = this;
		} else {
			leader = this.peers.get(leaderId);
		}
		
		if(leader == null) {
			System.out.println("Unable to find leader, waiting until one is selected...");
			while(this.leaderId == -1) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Found leader now...scheduling");
			this.insertAppointment(appointment);
		}
		
		// Send propose msg to leader
		DatagramSocket socket;
		try {
			System.out.println("Sending propose msg to leader.." + leader.id);
			InetSocketAddress addr = new InetSocketAddress(this.udpPort);
			socket = new DatagramSocket(null);
			socket.setReuseAddress(true);
			socket.setBroadcast(true);
			socket.bind(addr);
			UDPMessage msgObj = new UDPMessage("propose", -1, newCalendar, nextLogSlot, this.id);
			msgObj.print();
			byte[] buf = new byte[4096];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(msgObj);
			oos.flush();
			byte[] data = baos.toByteArray();
			InetAddress add = InetAddress.getByName("localhost");
			DatagramPacket packet = new DatagramPacket(data, data.length, add, leader.udpPort);
			socket.send(packet);
			socket.close();
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public static void main(String args[]) {
		Node node = new Node(Integer.parseInt(args[0]));
		node.loadIpTable();
		node.loadFromFirebasenew();
		//Logger logger = new MyLogger(node).LOGGER;
		
		//logger.info("Node " + node.id + " started with port number " + node.port);
		new Thread(new LeaderElection(node)).start();
		new Thread(new Paxos(node)).start();
		
		System.out.println(">> Node " + node.id + "started...");
		System.out.println(">> Enter schedule..");
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			
			if(input.equals("quit")) {
				node.terminate();
				break;
			} 
			else {
				node.parseCommand(input);
			}
		}
		
		LogManager.getLogManager().reset();
		
	}
	
	public void loadFromFirebasenew() {
		final AtomicBoolean done = new AtomicBoolean(false);
		Firebase ref = new Firebase("https://distributedcalendar.firebaseio.com/");
		final HashMap<Integer, Calendar> myHashMap = new HashMap<Integer, Calendar>();
		ref.addValueEventListener(new ValueEventListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if(snapshot.child("logFile").getChildrenCount() > 0) {
					 for (DataSnapshot messageSnapshot: snapshot.child("logFile").getChildren()) {
				            System.out.println("%%%% " + messageSnapshot.getKey());
				            DatabaseObject dbObject = (DatabaseObject)messageSnapshot.getValue(DatabaseObject.class);
				            System.out.println("DBOBJECT:" + dbObject);
				            
				            System.out.println("LOGSLOT:" + dbObject.getLogSlot());
				            System.out.println("Calendar:" + dbObject.getCal());
				            
				            myHashMap.put( new Integer(dbObject.getLogSlot()), dbObject.getCal());
				        }
					 done.set(true);
					
				}
			}
			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub	
			}
		});
		 while (!done.get());
		 
		 //Set new values to node's log and calendar
		 this.log = myHashMap;
		 this.calendar = this.log.get(Collections.max(this.log.keySet()));
		 System.out.println("Finished setting new values from DB to node");
	
	}


}
