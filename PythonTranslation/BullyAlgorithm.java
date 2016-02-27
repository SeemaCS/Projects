package PythonTranslation;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

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
		new Thread(new SendMessage(this.n, MessageType.ELECTION)).start();
		boolean receivedOkay = false;
		
		while(true) {
			try {
				serverSoc.setSoTimeout(timeout);
				Socket receiverSoc = serverSoc.accept();
				InputStream is = receiverSoc.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				MessageParameters messageObj = (MessageParameters) ois.readObject();
				if(messageObj != null) {
					if((messageObj.msg).equals("ELECTION")) {
						if(messageObj.id < n.id) {
							new Thread(new SendMessage(this.n, MessageType.OKAY, messageObj.id)).start();
							continue;
						}
					}
					else if((messageObj.msg).equals("COORDINATOR")) {
						n.id = messageObj.id;
						break;
					}
					else if((messageObj.msg).equals("OKAY")) {
						receivedOkay = true;
						continue;
					}
				}
			} catch (SocketException e) {
				if (!receivedOkay){
					new Thread(new SendMessage(this.n, MessageType.COORDINATOR)).start();
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
