import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class UIServer implements Runnable{
	Node node;
	
	public UIServer(Node node) {
		this.node = node;
	}

	@Override
	public void run() {
		try {
			System.out.println("UISERVER is up");

		
			ServerSocket serverSoc = new ServerSocket(node.uiPort);
			System.out.println("UISERVER is up on port: "+ node.uiPort);
			while(true) {
				System.out.println("UISERVER:..Waiting for client..");
				Socket receiverSoc = serverSoc.accept();
				System.out.println("Got client....creating new thread to work on it...");
				//new Thread(new UIMessageHandler(receiverSoc)).start();
				Thread.sleep(1100);
				new UIMessageHandler(node, receiverSoc).run();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	public static void main(String[] args) {
//		new UIServer().run();
//	}
	
}
