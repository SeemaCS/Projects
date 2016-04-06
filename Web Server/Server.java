
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {
	
	//public static final int PORT_NUMBER = 8080;
	
	public static void main(String[] args)  {
		
		String portId = "8038";
		int port = Integer.parseInt(portId);
		String documentRoot = "/Users/lakshitha/dummy_wget_example/www.scu.edu/";

		ServerSocket serverSoc;
		Socket clientSoc; 
		try {
			serverSoc = new ServerSocket(port);
		
		boolean keepAlive = false;
		while(true) {
			
			clientSoc = serverSoc.accept();
			clientSoc.setSoTimeout(5000);
				new Thread(new HandleRequest(clientSoc, documentRoot)).start();;
			}
		} catch (SocketTimeoutException se) {
			System.out.println("####################");
		/*try {
			//clientSoc.close();
		}*/ /*catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		}
		catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		
	}

}
