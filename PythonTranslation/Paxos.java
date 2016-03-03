import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Paxos implements Runnable {

	Node node;
	Logger logger;

	public Paxos(Node node) {
		this.node = node;
		logger = new MyLogger(node).LOGGER;
	}

	@Override
	public void run() {
		new Thread(node.proposer).start();
		new Thread(node.acceptor).start();
		new Thread(new Learner(node)).start();
		new Thread(new Shutdown(node)).start();
		//start learner and shutdown
		try {
			DatagramSocket serverSocket = new DatagramSocket(null);
			serverSocket.setReuseAddress(true);
			serverSocket.setBroadcast(true);
			InetSocketAddress address = new InetSocketAddress(node.udpPort);
			serverSocket.bind(address);
			byte[] receiveData;

			while(true) {
				System.out.println("Starting paxos while loop");
				receiveData = new byte[4096];
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				System.out.println("Waiting for Datagram Packet to arrive on port.." + node.udpPort);

				serverSocket.receive(receivePacket);
				System.out.println("Received packet");
				byte[] data = receivePacket.getData();
				ByteArrayInputStream bais = new ByteArrayInputStream(data);
				ObjectInputStream ois = new ObjectInputStream(bais);
				UDPMessage msgObj = (UDPMessage)ois.readObject();
				msgObj.print();
				if(msgObj != null) {
					if(msgObj.msgType.equals("terminate")) {
						serverSocket.close();
						break;
					}
					
					// Coded by me
					UDPMessage newMessage = new UDPMessage(new String(msgObj.msgType), 
							msgObj.m, new Calendar(msgObj.calendar), msgObj.logSlot, msgObj.senderID);
					
					if(msgObj.msgType.equals("promise") || msgObj.msgType.equals("ack")) {
						newMessage = new UDPMessage(new String(msgObj.msgType), new Calendar(msgObj.acceptedVal),
								msgObj.acceptedNum, msgObj.logSlot, msgObj.senderID); 
	
					}
					parseUDPMessage(newMessage);
					System.out.println("Done parsing udp message");
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void parseUDPMessage(UDPMessage msg) {
		System.out.println("In parse UDP message of paxos...");
		List<String> validMsgTypes = new ArrayList<String>();
		validMsgTypes.add("propose");
		validMsgTypes.add("prepare");
		validMsgTypes.add("promise");
		validMsgTypes.add("accept");
		validMsgTypes.add("ack");
		validMsgTypes.add("commit");
		if(!validMsgTypes.contains(msg.msgType)) {
			System.out.println("Invalid Message Type");
			return;
		}
		System.out.println("Parsing UDP msg  "+msg.msgType);
		if(msg.msgType.equals("propose")) {
			System.out.println("Message type is propose");
			int proposedSlot = msg.logSlot;
			for(int i = 0; i < proposedSlot; i++) {
				if(!node.log.keySet().contains(i)) {
					Calendar slotCalendar = node.acceptor.acceptedValues.get(i);
					node.log.put(i, slotCalendar);
				}
			}
			node.proposer.commandQueue.add(msg);
			return;
		}
		else if(msg.msgType.equals("prepare")) {
			node.acceptor.commandQueue.add(msg);
			return;
		}
		else if(msg.msgType.equals("promise")) {
			node.proposer.commandQueue.add(msg);
			return;
		}
		else if(msg.msgType.equals("accept")) {
			node.acceptor.commandQueue.add(msg);
			return;
		}
		else if(msg.msgType.equals("ack")) {
			node.proposer.commandQueue.add(msg);
			return;
		}
		else if(msg.msgType.equals("commit")) {
			node.acceptor.commandQueue.add(msg);
			return;
		}

		System.out.println("Reached after if else in parse UDP message");
		System.out.println("Returning now in parse UDP message");
		return;
	}
	
}
