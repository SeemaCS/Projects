import java.io.IOException;
import java.net.InetAddress;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;


public class SendMessageThread implements Runnable{

	Node n;
	MessageType type;
	int receiverId;

	public SendMessageThread(Node n, MessageType type) {
		this.n = n;
		this.type = type;
	}
	
	public SendMessageThread(Node n, MessageType type, int receiverId) {
		this.n = n;
		this.type = type;
		this.receiverId = receiverId;
	}

	@Override
	public void run() {
		switch(type) {
		case ELECTION :
			sendElectionMessage();
			break;
		case COORDINATOR :
			sendCoordinatorMessage();
			break;
		case OKAY :
			sendOkayMessage();
			break;
		}

	} 

	public void sendElectionMessage() {
		try {
			Thread.sleep(1000);
			for(Map.Entry<Integer, Node> entries : n.peers.entrySet()) {
				int key = entries.getKey();
				Node value = entries.getValue();
				if(key > n.id) {
					sendMessageOnSocket(value.port, value.ipAddress, "ELECTION");
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendCoordinatorMessage() {
		for(Map.Entry<Integer, Node> entries : n.peers.entrySet()) {
			int key = entries.getKey();
			Node value = entries.getValue();
			if(key != n.id) {
				sendMessageOnSocket(value.port, value.ipAddress, "COORDINATOR");
			}
		}
	}
	
	public void sendOkayMessage() {
		for(Map.Entry<Integer, Node> entries : n.peers.entrySet()) {
			int key = entries.getKey();
			Node value = entries.getValue();
			if(key == receiverId) {
				sendMessageOnSocket(value.port, value.ipAddress, "OKAY");
			}
		}
	}
	
	public void sendMessageOnSocket(int port, String ipAddress, String msg) {
		Socket senderSoc;
		try {

			System.out.println("Sending message to Node on port " + port);
			InetAddress add = InetAddress.getByName("localhost");

			senderSoc = new Socket(add, port);
			 System.out.println("Sender socket..");
			if(senderSoc != null) {
			 System.out.println("SenderSocket not null");
			OutputStream os = senderSoc.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			MessageParameters messageObject = new MessageParameters(n.id, msg);
			oos.writeObject(messageObject);
			oos.flush();
			 System.out.println("oos flushed");
			senderSoc.close();
			 System.out.println("Sender socket closed..");
			}
			else {
				System.out.println("Sendersoc is null...");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Port " + port + " is unreachable..");
		}
	}

}
