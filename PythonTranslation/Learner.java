import java.util.Collections;


public class Learner implements Runnable {

	Node n;
	
	public Learner(Node n) {
		this.n = n;
	}
	@Override
	public void run() {
		while(true) {
			if(!n.acceptor.commitsQueue.isEmpty()) {
				CommitQueueObject obj = n.acceptor.commitsQueue.get(n.acceptor.commitsQueue.size()-1);
				n.acceptor.commitsQueue.remove(n.acceptor.commitsQueue.size()-1);
				System.out.println("Committing to log file....");
				System.out.println("Log slot:" + obj.logSlot);
				System.out.println("Calendar:" + obj.v);
				n.log.put(obj.logSlot, obj.v);
				n.calendar = n.log.get(Collections.max(n.log.keySet()));
			}
			if(n.terminate) {
				break;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
