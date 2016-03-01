import java.io.Serializable;


public class UDPMessage implements Serializable {
	String msgType;
	int m;
	String calendarString;
	int logSlot;
	
	public UDPMessage(String msgType, int m, String calendarString, int logSlot) {
		this.msgType = msgType;
		this.m = m;
		this.calendarString = calendarString;
		this.logSlot = logSlot;
	}

}
