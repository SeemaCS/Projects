import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;


public class PromiseListener implements Runnable {
	
	Proposer proposer;
	//Set<Integer> logSlots;
	int numNodes;
	int majority;
	
	public PromiseListener(Proposer proposer) {
		this.proposer = proposer;
	}

	@Override
	public void run() {
		while(true) {
			//logSlots = proposer.promiseQueue.keySet();
			numNodes = proposer.node.peers.size()+ 1;
			majority = (int) (Math.ceil(numNodes/2.0));
			//Iterator slot = proposer.promiseQueues.iterator();
			for(int slot= 0; slot < proposer.promiseQueues.size(); slot++) {
				ArrayList<QueueObject> slotQueue = (ArrayList<QueueObject>) proposer.promiseQueues.get(slot);
				int numberPromises = slotQueue.size();
				if(numberPromises >= majority) {
					int m = -1;
					Object v = null;;  // check actual value that is coming for v
					for(int i = 0; i < numberPromises; i++){
						QueueObject queueObj = slotQueue.get(i);
						if(queueObj.accNum != -1 && queueObj.accVal != null) {
							if(queueObj.accNum > m) {
								m = proposer.myProposals.get(slot).get(0);
								v = queueObj.accVal;
							}
						}
					}
					proposer.sendAccept(m,v,slot);
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
