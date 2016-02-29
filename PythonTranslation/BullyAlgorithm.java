import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class BullyAlgorithm implements Runnable{
	
	Node n;
	int timeout; 
	ServerSocket serverSoc;  

	public BullyAlgorithm(Node n, int timeout, ServerSocket serverSoc) {
		this.n = n;
		this.timeout = timeout;
		this.serverSoc = serverSoc;
	}
	
	@Override
	public void run() {
		//Send message

		System.out.println("Starting Bully Algorithm");
		new Thread(new SendMessageThread(this.n, MessageType.ELECTION)).start();
		boolean receivedOkay = false;
		
		System.out.println("Message sent...waiting to receive object");
		while(true) {
			try {
				serverSoc.setSoTimeout(timeout);
				 System.out.println("Before recSocket accept...");
				Socket receiverSoc = serverSoc.accept();
				 System.out.println("ReceiverSocket accepted...");
				if(receiverSoc != null) {
					System.out.println("ReceiverSocket not null");
				}
				else {
					 System.out.println("ReceiverSocket null");
				}
				InputStream is = receiverSoc.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				MessageParameters messageObj = (MessageParameters) ois.readObject();
				if(messageObj != null) {
					 System.out.println("Message obj not null");
					System.out.println("Message msg: = " + messageObj.msg);
					System.out.println("Message msg id: = " + messageObj.id);
					System.out.println("Message msg nodeId: = " + n.id);
					if((messageObj.msg).equals("COORDINATOR")) {
                                                n.leaderId = messageObj.id;
                                                break;
                                        }
					if((messageObj.msg).equals("ELECTION")) {
						if(messageObj.id < n.id) {
							new SendMessage(this.n, MessageType.OKAY, messageObj.id);
							new Thread(new SendMessageThread(this.n, MessageType.ELECTION)).start();							
							continue;
						}
					}
					if((messageObj.msg).equals("OKAY")) {
						receivedOkay = true;
						continue;
					}
				}
			} catch (SocketTimeoutException e) {

				System.out.println("Socket timed out...");
				System.out.println("recievedOkay?.." + receivedOkay);
				if (!receivedOkay){
					 System.out.println("I am the coordinator..");
					new Thread(new SendMessageThread(this.n, MessageType.COORDINATOR)).start();
					n.leaderId = n.id;
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}
