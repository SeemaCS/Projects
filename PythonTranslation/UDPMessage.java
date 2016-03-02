import java.io.Serializable;
import java.util.HashMap;


public class UDPMessage implements Serializable {
	String msgType;
	int m;
	Calendar calendar;
	int logSlot;
	int senderID;
	int acceptedNum;
	Calendar acceptedVal;
	
	public UDPMessage(String msgType, int m, Calendar calendar, int logSlot, int senderID) {
		this.msgType = msgType;
		this.m = m;
		this.calendar = calendar;
		this.logSlot = logSlot;
		this.senderID = senderID;
	}
	
	public UDPMessage(String msgType, Calendar acceptedVal, int acceptedNum, int logSlot, int senderID) {
		this.msgType = msgType;
		this.acceptedNum = acceptedNum;
		this.acceptedVal = acceptedVal;
		this.logSlot = logSlot;
		this.senderID = senderID;
	}
	
	public void print() {
		System.out.println("Message Type = "+msgType+"M = "+m+"logSlot= "+logSlot+
				"SenderID = "+senderID+"AcceptedNum= "+acceptedNum+"Calendar Object"+calendar);
	}
	
	/*public UDPMessage(String msgType, int logSlot, int senderID) {
		this.msgType = msgType;
		this.logSlot = logSlot;
		this.senderID = senderID;
		acceptedValues = new HashMap<Integer, Calendar>();
		acceptedNumbers = new HashMap<Integer, Integer>();
	}*/

}
