import java.util.ArrayList;
import java.time.LocalTime; 
import java.time.LocalDate;
import java.util.Scanner;

public class TrafficViolationLog extends Logs
{
	Scanner input = new Scanner(System.in);
	public int VID;
	public double PenaltyAmount,speed;
	public String Reason;
	public String regno;
	
	public TrafficViolationLog( int id,double p,String reason, String regno,double speed,int roadid,int policeid,int stationid,String type)
	{
		super(id,roadid,policeid,stationid,type);
		id=VID;
	
		this.PenaltyAmount=p;
		this.Reason=reason;
		this.regno=regno;
		this.speed=speed;	
	}
	
}
