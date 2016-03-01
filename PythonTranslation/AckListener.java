import java.util.ArrayList;


public class AckListener implements Runnable {
	
	Proposer proposer;
	int numNodes;
	int majority;
	
	public AckListener(Proposer proposer) {
		this.proposer = proposer;
	}

	@Override
	public void run() {
		while(true) {
			numNodes = proposer.node.peers.size()+ 1;
			majority = (int) (Math.ceil(numNodes/2.0));
			for(int slot= 0; slot < proposer.ackQueues.size(); slot++) {
				ArrayList<QueueObject> slotQueue = (ArrayList<QueueObject>) proposer.ackQueues.get(slot);
				int numberAcks = slotQueue.size();
				Object v = null;
				if(numberAcks >= majority) {
					if(!proposer.committedSlots.contains(slot)) {
						v = slotQueue.get(0);
						proposer.sendCommit(v, slot);
						proposer.committedSlots.add(slot);
					}
	
				}
			}
			if(proposer.terminate) {
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
