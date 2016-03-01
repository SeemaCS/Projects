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
import java.util.Map;


public class Proposer implements Runnable {

	Node node;
	int uid;
	int currentProposalNumber;
	List<UDPMessage> commandQueue;
	List<Integer> committedSlots;
	ArrayList<ArrayList<Integer>> myProposals;
	/*HashMap<Integer, String> promiseQueues;
	HashMap<Integer, String> ackQueues;*/
	ArrayList<ArrayList<QueueObject>> promiseQueues;
	ArrayList<ArrayList<QueueObject>> ackQueues;
	boolean terminate = false;
	boolean isProposer = true;

	public Proposer(Node node) {
		this.node = node;
		this.uid = node.id;
		this.currentProposalNumber = this.uid;
		commandQueue = new ArrayList<UDPMessage>();
		committedSlots = new ArrayList<Integer>();
		myProposals = new ArrayList<ArrayList<Integer>>();
		promiseQueues = new ArrayList<ArrayList<QueueObject>>();
		ackQueues = new ArrayList<ArrayList<QueueObject>>();
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
		

	}

	public void receivePromise(UDPMessage message) {

	}

	public void receiveAck(UDPMessage message) {

	}

	public void sendAccept(int m, Object v, int logSlot){

		// Redo calendar object
		UDPMessage msg = new UDPMessage("accept", m, null, logSlot);
		for(Map.Entry<Integer, Node> entries : node.peers.entrySet()) {
			int key = entries.getKey();
			Node value = entries.getValue();
			sendUDPMessage(msg, value.udpPort, value.ipAddress);
		}

	}

	public void sendCommit(Object v, int logSlot){

		// Redo calendar object
		UDPMessage msg = new UDPMessage("accept", -1, null, logSlot);
		for(Map.Entry<Integer, Node> entries : node.peers.entrySet()) {
			int key = entries.getKey();
			Node value = entries.getValue();
			sendUDPMessage(msg, value.udpPort, value.ipAddress);
		}

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
