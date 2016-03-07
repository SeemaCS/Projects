import java.util.Date;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class DatabaseThread  implements Runnable {
	
	DatabaseObject dbObj;
	
	public static int counter = 0;
	
	public DatabaseThread() {
		
	}
	
	public DatabaseThread(DatabaseObject dbObj) {
		this.dbObj = dbObj;
	//	counter++;
	}
	
	@Override
    public void run() {
		System.out.println("[FirebaseThread] Pushing data to Firebase");
        Firebase ref = new Firebase("https://distributedcalendar.firebaseio.com/");
        Firebase logFileRef = ref.child("logFile");
        logFileRef.push().setValue(dbObj, new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
              //  System.out.println(System.currentTimeMillis() + " Done");
            }
        });
    }
	
	
//	Calendar cal;
//	
//	public DatabaseThread() {
//		
//	}
//	
//	public DatabaseThread(Calendar cal) {
//		this.cal = cal;
//	}
//	
//	@Override
//    public void run() {
//        Firebase ref = new Firebase("https://distributedcalendar.firebaseio.com/");
//        Firebase logFileRef = ref.child("logFile");
//      
//        logFileRef.push().setValue(cal, new Firebase.CompletionListener() {
//            @Override
//            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
//                System.out.println(System.currentTimeMillis() + " Done");
//            }
//        });
//    }
}
