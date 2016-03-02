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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Proposer implements Runnable {

	Node node;
	int uid;
	int currentProposalNumber;
	List<UDPMessage> commandQueue;
	List<Integer> committedSlots;
	HashMap<Integer, ProposerProposal> myProposals;
	/*HashMap<Integer, String> promiseQueues;
	HashMap<Integer, String> ackQueues;*/
	HashMap<Integer, LinkedHashMap<Integer, QueueObject>> promiseQueues;
	HashMap<Integer, LinkedHashMap<Integer, QueueObject>> ackQueues;
	boolean terminate = false;
	boolean isProposer = true;

	public Proposer(Node node) {
		this.node = node;
		this.uid = node.id;
		this.currentProposalNumber = this.uid;
		commandQueue = new ArrayList<UDPMessage>();
		committedSlots = new ArrayList<Integer>();
		myProposals = new HashMap<Integer, ProposerProposal>();
		promiseQueues = new HashMap<Integer, LinkedHashMap<Integer, QueueObject>>();
		ackQueues = new HashMap<Integer, LinkedHashMap<Integer, QueueObject>>();
		/*promiseQueues = new HashMap<Integer, String>();
		ackQueues = new HashMap<Integer, String>();*/
	}



	@Override
	public void run() {
		new Thread(new PromiseListener(this)).start();
		new Thread(new AckListener(this)).start();

		while(true) {
			if(!commandQueue.isEmpty()) {
				UDPMessage message = commandQueue.get(commandQueue.size()-1);
				message.print();
				if(message.msgType.equals("propose")){
					sendPrepare(message);
				}
				if(message.msgType.equals("promise")) {
					receivePromise(message);
				}
				if(message.msgType.equals("ack")) {
					receiveAck(message);
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


	public void sendPrepare(UDPMessage message) {
		this.currentProposalNumber += 10;
		int m = currentProposalNumber;
		Calendar calendar = message.calendar;
		int logSlot = message.logSlot;
		this.myProposals.put(logSlot, new ProposerProposal(m, calendar));

		UDPMessage msg = new UDPMessage("prepare", m, null, logSlot, this.node.id);

		for(Map.Entry<Integer, Node> entries : this.node.peers.entrySet()) {
			int key = entries.getKey();
			Node value = entries.getValue(); 
			this.sendUDPMessage(msg, value.port, value.ipAddress);
		}
	}

	public void receivePromise(UDPMessage message) {
		LinkedHashMap<Integer, QueueObject> promiseQueueValue = this.promiseQueues.get(message.logSlot) ; 
		if(promiseQueueValue== null) {
			promiseQueueValue = new LinkedHashMap<Integer, QueueObject>();
			promiseQueueValue.put(message.senderID, new QueueObject(message.acceptedNum, message.acceptedVal));
			this.promiseQueues.put(message.logSlot, promiseQueueValue);
		}
		else {
			promiseQueueValue.put(message.senderID, new QueueObject(message.acceptedNum, message.acceptedVal));
			this.promiseQueues.put(message.logSlot, promiseQueueValue);
		}
	}

	public void receiveAck(UDPMessage message) {
		LinkedHashMap<Integer, QueueObject> ackQueueValue = this.ackQueues.get(message.logSlot) ; 
		if(ackQueueValue== null) {
			ackQueueValue = new LinkedHashMap<Integer, QueueObject>();
			ackQueueValue.put(message.senderID, new QueueObject(message.acceptedVal));
			this.ackQueues.put(message.logSlot, ackQueueValue);
		}
		else {
			ackQueueValue.put(message.senderID, new QueueObject(message.acceptedVal));
			this.ackQueues.put(message.logSlot, ackQueueValue);
		}
	}

	public void sendAccept(int m, Calendar v, int logSlot){
		UDPMessage msg = new UDPMessage("accept", m, v, logSlot, this.node.id);
		for(Map.Entry<Integer, Node> entries : node.peers.entrySet()) {
			int key = entries.getKey();
			Node value = entries.getValue();
			sendUDPMessage(msg, value.udpPort, value.ipAddress);
		}

	}

	public void sendCommit(Calendar v, int logSlot){
		UDPMessage msg = new UDPMessage("commit", -1, v, logSlot, this.node.id);
		for(Map.Entry<Integer, Node> entries : node.peers.entrySet()) {
			int key = entries.getKey();
			Node value = entries.getValue();
			sendUDPMessage(msg, value.udpPort, value.ipAddress);
		}
	}

	public void sendUDPMessage(UDPMessage msg, int udpPort, String ipAddress) {
		try {
			msg.print();
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
