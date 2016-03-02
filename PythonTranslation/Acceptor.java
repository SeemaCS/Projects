import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Acceptor implements Runnable {

	Node node;
	HashMap<Integer, Calendar> acceptedValues;
	List<UDPMessage> commandQueue;
	int maxPrepare;
	HashMap<Integer, Integer> accNums;
	HashMap<Integer, Calendar> accVals;
	boolean terminate = false;
	boolean isAcceptor = true;
	List<CommitQueueObject> commitsQueue;


	public Acceptor(Node node) {
		this.node = node;
		maxPrepare = -1;
		acceptedValues = new HashMap<Integer, Calendar>();
		commandQueue = new ArrayList<UDPMessage>();
		accNums = new HashMap<Integer, Integer>();
		accVals = new HashMap<Integer, Calendar>(); 
		commitsQueue = new ArrayList<CommitQueueObject>();
	}

	@Override
	public void run() {
		while(true) {
			if(!commandQueue.isEmpty()) {
				UDPMessage message = commandQueue.get(commandQueue.size()-1);
				if(message.msgType.equals("prepare")){
					receivePrepare(message);
				}
				if(message.msgType.equals("accept")) {
					receiveAccept(message);
				}
				if(message.msgType.equals("commit")) {
					receiveCommit(message);
				}
			}
			if(this.terminate) {
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


	}


	public void receivePrepare(UDPMessage msg) {
		int m = msg.m;
		int senderID = msg.senderID;
		int logSlot = msg.logSlot;
		String ipAddress = "";
		int port;
		
		if(!this.accNums.keySet().contains(logSlot)) {
			this.accNums.put(logSlot, -1);	
		}
		
		if(!this.accVals.keySet().contains(logSlot)) {
			this.accVals.put(logSlot, null);	
		}
		
		if(m > this.maxPrepare) {
			this.maxPrepare = m;
			if(this.node.id == senderID) {
				ipAddress = this.node.ipAddress;
				port = this.node.udpPort;
			}
			else {
				Node n = this.node.peers.get(senderID);
				ipAddress = n.ipAddress;
				port = n.udpPort;
			}
			sendPromise(ipAddress, port, this.accNums.get(logSlot), this.accVals.get(logSlot), logSlot);
		}

	}

	public void sendPromise(String ipAddress, int port, int accNum, Calendar accVal, int logSlot) {
		UDPMessage msg = new UDPMessage("promise", accVal, accNum, logSlot, this.node.id);
		sendUDPMessage(msg, port, ipAddress);
	}

	public void receiveAccept(UDPMessage msg) {
		int m = msg.m;
		Calendar v = msg.calendar;
		int senderID = msg.senderID;
		int logSlot = msg.logSlot;
		String ipAddress = "";
		int port;
		
		if(!this.accNums.keySet().contains(logSlot)) {
			this.accNums.put(logSlot, -1);	
		}
		
		if(!this.accVals.keySet().contains(logSlot)) {
			this.accVals.put(logSlot, null);	
		}
		
		if(m > this.maxPrepare) {
			this.accNums.put(logSlot, m);	
			this.accVals.put(logSlot, v);
			if(this.node.id == senderID) {
				ipAddress = this.node.ipAddress;
				port = this.node.udpPort;
			}
			else {
				Node n = this.node.peers.get(senderID);
				ipAddress = n.ipAddress;
				port = n.udpPort;
			}
			sendAck(ipAddress, port, this.accNums.get(logSlot), this.accVals.get(logSlot), logSlot);
		}

	}

	public void sendAck(String ipAddress, int port, int accNum, Calendar accVal, int logSlot) {
		UDPMessage msg = new UDPMessage("ack", accVal, accNum, logSlot, this.node.id);
		sendUDPMessage(msg, port, ipAddress);
	}

	public void receiveCommit(UDPMessage msg) {
		this.commitsQueue.add(new CommitQueueObject(msg.logSlot, msg.calendar));
	}

	public void sendUDPMessage(UDPMessage msg, int udpPort, String ipAddress) {
		try {
			DatagramSocket socket = new DatagramSocket(node.udpPort);
			byte[] buf = new byte[4096];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(msg);
			oos.flush();
			byte[] data = baos.toByteArray();
			InetAddress add = InetAddress.getByName("localhost");
			DatagramPacket packet = new DatagramPacket(data, data.length, add, udpPort);
			socket.send(packet);
			socket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
