import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Appointment implements Serializable{
	
	@Override
	public String toString() {
		String str = "[";
//		System.out.println(name);
//		System.out.println(day);
//		System.out.println(startTime);
//		System.out.println(endTime);
		
		str += "Name:" + name;
		str += ",Day:" + day;
		str += ",StartTime:" + startTime;
		str += ",EndTime:" + endTime;
		str += ",Participants:(" ;
		for(int i : participants) {
			//System.out.println(i);
			str += i + "," ;
		}
		return ")]" + str;
	}

	String name;
	String day;
	String startTime;
	String endTime;
	List<Integer> participants;
	
	boolean isAppointment = true;
	
	public Appointment(String name, String day, String startTime, String endTime, List<Integer> participants) {
		this.name = name;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.participants = participants;
	}
	
	public Appointment(Appointment app) {
		this.name = new String(app.name);
		this.day = new String(app.day);
		this.startTime = new String(app.startTime);
		this.endTime = new String(app.endTime);
		
		this.participants = new ArrayList<Integer>();
		for(Integer i: app.participants) {
			this.participants.add(i);
		}
	}

}
