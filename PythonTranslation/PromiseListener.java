import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;
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
//		System.out.println("Promise Listener is up");
		
		while(true) {
			numNodes = proposer.node.peers.size()+ 1;
			majority = (int) (Math.ceil(numNodes/2.0));
			
			if(!this.proposer.promiseQueues.isEmpty()) {
				//System.out.println("Promise Listener --- Promise Queue not empty");
			}
			
			for(Map.Entry<Integer, LinkedHashMap<Integer, QueueObject>> slotEntry: this.proposer.promiseQueues.entrySet()){
				Integer slot = slotEntry.getKey();
				HashMap<Integer, QueueObject> slotQueue = slotEntry.getValue();
				int numberPromises = slotQueue.size();
				//System.out.println("Number of promises:" + numberPromises);
				//System.out.println("Majority:" + majority);
				if(numberPromises >= majority) {
				//	System.out.println("Inside if > : Number promises:" + numberPromises + " Majority:" + majority);
					int m = -1;
					Calendar v = new Calendar();
					for(Map.Entry<Integer, QueueObject> queueEntry : slotQueue.entrySet()) {
					//	System.out.println("In for loop of slotQUeue...");
						int key = queueEntry.getKey();
					//	System.out.println("Looking for logslot:" + key);

						QueueObject value = queueEntry.getValue();
					//	System.out.println("Value of accNum:" + value.accNum);
					//	System.out.println("Value of m:" + m);
						if(value.accNum != -1) {
							if(value.accNum > m) {
							//	System.out.println("Value of accNum:" + value.accNum);
								m = this.proposer.myProposals.get(slot).proposalNumber;
								v = this.proposer.myProposals.get(slot).calendar;
								//v = value.accVal;
							}
						}
					}
					if(!this.proposer.committedSlots.contains(slot)) {
						this.proposer.sendAccept(m, v, slot);
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
