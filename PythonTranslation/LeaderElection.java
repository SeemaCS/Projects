import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Logger;

public class LeaderElection implements Runnable {

	public static final int POLL_TIME = 6000;
	public static final int TIMEOUT = 3000;
	Node n;
	Logger logger;
	
	public LeaderElection(Node n) {
		this.n = n;
		logger = new MyLogger(n).LOGGER;
	}
	
	@Override
	public void run() {
		try {
			ServerSocket serverSoc = new ServerSocket(n.port);
			int prevLeaderId = -1;
			while(true) {
				new Thread(new BullyAlgorithm(this.n, TIMEOUT, serverSoc)).start();
				Thread.sleep(POLL_TIME);
				
				logger.info("Bully Algorithm done...");
				logger.info("LEADER IS: " + n.leaderId);
				if(n.leaderId != prevLeaderId) {
					logger.info("LEADER IS: " + n.leaderId);
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
	

}
