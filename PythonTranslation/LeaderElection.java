import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.logging.Logger;

public class LeaderElection implements Runnable {

	public static final int POLL_TIME = 15000;
	public static final int TIMEOUT = 3000;
	Node n;
	//Logger logger;
	
	public LeaderElection(Node n) {
		this.n = n;
		//logger = new MyLogger(n).LOGGER;
	}
	
	@Override
	public void run() {
		try {
			ServerSocket serverSoc = new ServerSocket(n.port);
			int prevLeaderId = -1;
			while(true) {
				//System.out.println("Checking if there is a valid leader...." + n.leaderId);
				
				// If no leader, elect leader....
				
				if(prevLeaderId == -1 || !(prevLeaderId > n.leaderId)) {
					//System.out.println("Starting BULLY");
					//System.out.println("Node id " +  n.leaderId);
					//System.out.println("Node id " +  );
				//new code
//				NewBully nb = new NewBully(this.n, TIMEOUT, serverSoc);
//				nb.run();
					new Thread(new BullyAlgorithm(this.n, TIMEOUT, serverSoc)).start();
				
				//new Thread(new BullyAlgorithm(this.n, TIMEOUT, serverSoc)).start();
				
				}
				Thread.sleep(POLL_TIME);
				
			//	System.out.println("Bully Algorithm done...");
				System.out.println("[LeaderElectionThread] LEADER ELECTED, IS: " + n.leaderId);
				
				// Ping leader to c if hes alive. If hes not alive, make n.leaderId = -1
				
				
				//System.out.println("Bully Algorithm done...");
				//System.out.println("LEADER IS: " + n.leaderId);
				if(n.leaderId != prevLeaderId) {
					//System.out.println("LEADER IS: " + n.leaderId);
					prevLeaderId = n.leaderId;
				}
				if(n.terminate)
					break;
			}
			serverSoc.close();
		} catch (IOException e) {
		//	e.printStackTrace();
		} catch (InterruptedException e) {
		//	e.printStackTrace();
		}
	}
	
	public boolean isPrevLeaderReachable(int prevLeaderId) {
		boolean isReachable = false;
		InetAddress address;
		try {
			address = InetAddress.getByName("localhost");
			//System.out.println("Name: " + address.getHostName());
			if(address.isReachable(getPrevLeader(prevLeaderId).port)) {
				isReachable = true;
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			isReachable = false;
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			isReachable = false;
		//	e.printStackTrace();
		}
	       
	//	System.out.println("Checking if leader is reachable: " + isReachable);
	     return isReachable;
	}
	
	public Node getPrevLeader(int prevLeaderId) {
		Node leader = null;
		if(prevLeaderId == n.id)
			leader = n;
		else {
			for(Map.Entry<Integer, Node> entry: n.peers.entrySet()) {
				if(prevLeaderId == entry.getKey()) {
					leader = entry.getValue();
					break;
				}
			}
		}
		
		return leader;
	}
	
	/*
	 * @Override
	public void run() {
		try {
			ServerSocket serverSoc = new ServerSocket(n.port);
			int prevLeaderId = -1;
			while(true) {
				
				// If no leader, elect leader....
				
				if(n.leaderId == -1) {
				//new code
				NewBully nb = new NewBully(this.n, TIMEOUT, serverSoc);
				nb.run();
				//new Thread(new BullyAlgorithm(this.n, TIMEOUT, serverSoc)).start();
				
				}
				Thread.sleep(POLL_TIME);
				
				// Ping leader to c if hes alive. If hes not alive, make n.leaderId = -1
				
				System.out.println("Bully Algorithm done...");
				//System.out.println("LEADER IS: " + n.leaderId);
				if(n.leaderId != prevLeaderId) {
					System.out.println("LEADER IS: " + n.leaderId);
					prevLeaderId = n.leaderId;
				}
				if(n.terminate)
					break;
			}
			serverSoc.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	 */
	

}
