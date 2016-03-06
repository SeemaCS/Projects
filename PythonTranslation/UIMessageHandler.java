import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class UIMessageHandler{
	Socket clientSoc;
	Node n;

	public  UIMessageHandler(Node n, Socket clientSoc) {
		this.clientSoc = clientSoc;
		this.n = n;
	}
	
	//@Override
	public void run() {
		InputStream ios;
		OutputStream oos;
		
		try{
			ios = clientSoc.getInputStream();
			Scanner scan = new Scanner(ios);
			String message = scan.nextLine();
			
			System.out.println("Message from Mobile:" + message);
			String response = getResponseMessage(message);
			
			oos = clientSoc.getOutputStream();
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(oos)), true);
            out.println(response);
            out.flush();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				clientSoc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public String getResponseMessage(String requestMsg) {
		String response = "failure";
		
		String[] tokens = requestMsg.split(" ");
		if(tokens[0].equals("schedule")) {
			System.out.println("Scheduling appointment from client Mobile...");
			
			Appointment appointment = n.parseAppointment(tokens);
			boolean canInsert = n.insertAppointment(appointment);
			if(canInsert == true) {
				response = "success";
			}
		}
		else if(tokens[0].equals("cancel")) {
			Appointment appointment = n.parseAppointment(tokens);
			n.deleteAppointment(appointment);
			response = "success";
		}
		
		
		return response;
		
	}
	

	
	
}
