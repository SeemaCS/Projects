import java.io.Serializable;


public class UDPMessage implements Serializable {
	String msgType;
	int m;
	Calendar calendar;
	int logSlot;
	
	public UDPMessage(String msgType, int m, Calendar calendar, int logSlot) {
		this.msgType = msgType;
		this.m = m;
		this.calendar = calendar;
		this.logSlot = logSlot;
	}

}
