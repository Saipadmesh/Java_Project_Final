import java.util.ArrayList;
import java.time.LocalTime; 
import java.time.LocalDate;
import java.util.Scanner;



public class Logs
{
	Scanner input = new Scanner(System.in);
	public int LogID;
	public int RoadID,PoliceID,StationID;
	public String type;
	public LocalDate date = LocalDate.now();
	public LocalTime time = LocalTime.now();
	public Logs(int logid,int roadid,int policeid,int SID,String type ) 
	{
		LogID=logid;
		RoadID=roadid;
		PoliceID=policeid;
		StationID=SID;
		this.type=type;
	 }

	
}
