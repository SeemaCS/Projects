import java.io.IOException;
import java.net.InetAddress;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.logging.Logger;


public class SendMessageThread implements Runnable{

	Node n;
	MessageType type;
	int receiverId;
	Logger logger;

	public SendMessageThread(Node n, MessageType type) {
		this.n = n;
		logger = new MyLogger(n).LOGGER;
		this.type = type;
	}
	
	public SendMessageThread(Node n, MessageType type, int receiverId) {
		this.n = n;
		logger = new MyLogger(n).LOGGER;
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

			logger.info("Sending message to Node on port " + port);
			InetAddress add = InetAddress.getByName("localhost");

			senderSoc = new Socket(add, port);
			 logger.info("Sender socket..");
			if(senderSoc != null) {
			 logger.info("SenderSocket not null");
			OutputStream os = senderSoc.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			MessageParameters messageObject = new MessageParameters(n.id, msg);
			oos.writeObject(messageObject);
			oos.flush();
			 logger.info("oos flushed");
			senderSoc.close();
			 logger.info("Sender socket closed..");
			}
			else {
				logger.info("Sendersoc is null...");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("Port " + port + " is unreachable..");
		}
	}

}
