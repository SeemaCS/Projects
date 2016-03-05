import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

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
				if(n.leaderId == n.id) {
					//pushToFirebase(obj.logSlot, obj.v);
					 Thread t = new Thread(new DatabaseThread(new DatabaseObject(obj.logSlot, obj.v)));
				        t.start();
				        
				        try {
							t.join();
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        
				        
				}
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
	
//	public void pushToFirebase(int logSlot, Calendar cal) {
//		final AtomicBoolean done = new AtomicBoolean(false);
//
//		Firebase rootRef = new Firebase("https://torrid-fire-1695.firebaseio.com/");
//		Firebase ref = rootRef.child("logFile");
//		
//		ref.setValue(logSlot, new Firebase.CompletionListener() {
//			
//			@Override
//			public void onComplete(FirebaseError arg0, Firebase arg1) {
//				done.set(true);
//			}
//		}); 
//		 while (!done.get());
//	}

}
