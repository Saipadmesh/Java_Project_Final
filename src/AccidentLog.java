import java.util.ArrayList;
import java.util.Scanner;

public class AccidentLog extends Logs
{
	Scanner input = new Scanner(System.in);
	public int AccID;
	public int NoofPersonsInjured,NoofVehicles;
	public String DamageCaused,AccReason;
	ArrayList<String> regnos = new ArrayList<>();

	
	public AccidentLog(int id,String damage, String reason,int noofpersoninj,int noofvehicles,ArrayList<String> reg,int roadid,int policeid,int stationid,String type)
	{
		super(id,roadid,policeid,stationid,type);
		NoofVehicles=noofvehicles;
		regnos=reg;
		AccID=id;
		DamageCaused=damage;
		AccReason=reason;
		NoofPersonsInjured=noofpersoninj;
	}
}
