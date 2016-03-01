import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Node {

	int id;
	boolean isRunning = true;
	int port;
	int udpPort;
	String ipAddress;
	int leaderId = -1;
	boolean terminate = false;
	boolean isNode = true;
	Logger logger;
	HashMap<Integer, Node> peers = new HashMap<Integer, Node>();
	
	HashMap<Integer, Calendar> log = new HashMap<Integer, Calendar>();
	
	Calendar calendar = null;

	public Node(int id) {
		this.id = id;
		this.calendar = new Calendar();
		logger = new MyLogger(this).LOGGER;
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
			socket = new DatagramSocket(this.udpPort);
			UDPMessage msgObj = new UDPMessage("terminate", -1, null, -1);
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
			logger.info("Unable to find leader, waiting until one is selected...");
			while(this.leaderId == -1) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			logger.info("Found leader now...scheduling");
			this.insertAppointment(appointment);
		}
		
		//Ask leader to Send propose msg to others
		DatagramSocket socket;
		try {
			socket = new DatagramSocket(this.udpPort);
			UDPMessage msgObj = new UDPMessage("propose", -1, newCalendar, nextLogSlot);
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
		Logger logger = new MyLogger(node).LOGGER;
		
		logger.info("Node " + node.id + " started with port number " + node.port);
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

}
