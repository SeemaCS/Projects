
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;


public class HandleRequest implements Runnable {
	
	
	String incomingRequest = "";
	String root;
    DataOutputStream out;
    InputStream in;
    BufferedReader read;
    Socket clientSocket;
    
	public HandleRequest(Socket clientSocket, String root) throws IOException {
		this.clientSocket = clientSocket;
		/*in = clientSocket.getInputStream();
		read = new BufferedReader(new InputStreamReader(in));
		out = new DataOutputStream(clientSocket.getOutputStream());*/
		out = new DataOutputStream(clientSocket.getOutputStream());
		this.root = root;
		//this.incomingRequest = read.readLine();
	}
	
	public void run() {
		
		boolean isAlive = false;
		while(true) {
		FileHandler fileH = new FileHandler();
		if(this.incomingRequest != null) {
			isAlive = fileH.display(this.clientSocket, this.root, this.out);
		}
		if(!isAlive) {
			break;
		}
	}
	
		
		try {
			this.clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
