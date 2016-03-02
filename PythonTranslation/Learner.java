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
