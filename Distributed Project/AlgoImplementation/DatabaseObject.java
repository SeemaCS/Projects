import java.util.HashMap;


public class DatabaseObject {
	
//	HashMap<Integer, Calendar> log = new HashMap<Integer, Calendar>();
//	
//	public DatabaseObject() {
//		
//	}
//	
//	public DatabaseObject(HashMap<Integer, Calendar> log) {
//		super();
//		this.log = log;
//		
//	}
//
//	public HashMap<Integer, Calendar> getLog() {
//		return log;
//	}
//
//	public void setLog(HashMap<Integer, Calendar> log) {
//		this.log = log;
//	}
	
	
	/**
	 * Trying something like android
	 */
	
	
	int logSlot;
	Calendar cal;
	
	public DatabaseObject() {
		
	}
	public DatabaseObject(int logSlot, Calendar cal) {
		super();
		this.logSlot = logSlot;
		this.cal = cal;
	}
	public int getLogSlot() {
		return logSlot;
	}
	public void setLogSlot(int logSlot) {
		this.logSlot = logSlot;
	}
	public Calendar getCal() {
		return cal;
	}
	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	
	
	
	
}
