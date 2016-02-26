package PythonTranslation;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;


public class SendMessage implements Runnable {

	Node n;
	MessageType type;
	int receiverId;

	public SendMessage(Node n, MessageType type) {
		this.n = n;
		this.type = type;
	}
	
	public SendMessage(Node n, MessageType type, int receiverId) {
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
			Thread.sleep(10000);
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
			senderSoc = new Socket(ipAddress, port);
			OutputStream os = senderSoc.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			MessageParameters messageObject = new MessageParameters(n.id, msg);
			oos.writeObject(messageObject);
			oos.flush();
			senderSoc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
