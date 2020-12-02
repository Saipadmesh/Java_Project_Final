import java.util.ArrayList;
import java.util.Scanner;

public class Map {

    static ArrayList<Road> Roads = new ArrayList<>();
    static ArrayList<Junction> Junctions = new ArrayList<>();
    static ArrayList<Police_Station> PoliceStations = new ArrayList<>();
    //static ArrayList<Traffic_Police> TrafficPolice = new ArrayList<>();

    public static Road return_road(int RID){
        for(int i=0;i<Roads.size();i++){
            if(RID == Roads.get(i).RoadId){
                return Roads.get(i);
            }
        }
        return null;
    }

    public static Junction return_jn(int JID){
        for(int i=0;i<Junctions.size();i++){
            if(JID == Junctions.get(i).JunctionID){
                return Junctions.get(i);
            }
        }
        return null;
    }

    public static Traffic_Police return_police(Police_Station ps, int PID){
        ArrayList<Traffic_Police> TrafficPolice = ps.Personnel;
        for(int i=0;i<TrafficPolice.size();i++){
            if(PID == TrafficPolice.get(i).PoliceID){
                return TrafficPolice.get(i);
            }
        }
        return null;
    }

    public static Police_Station return_police_station(int SID){
        for(int i=0;i<PoliceStations.size();i++){
            if(SID == PoliceStations.get(i).StationID){
                return PoliceStations.get(i);
            }
        }
        return null;
    }

    public static void addJunction(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("Enter Junction ID : ");
        Scanner input = new Scanner(System.in);
        int JID = input.nextInt();
        System.out.println("Enter Junction Name : ");
        String Name = input.next();
        System.out.println("Enter Junction Type : ");
        String Type = input.next();
        System.out.println("Enter Number of Roads Connecting : ");
        ArrayList<Road> conn_roads = new ArrayList<>();
        int n = input.nextInt();
        int i = 0;
        while(i<n){
            System.out.println("Enter Road ID : ");
            int RID = input.nextInt();
            Road road = return_road(RID);
            if(road == null){
                System.out.println("Road does not exist. Try again...");
            }
            else{
                conn_roads.add(road);
                i++;
            }

        }
        input.close();
        Junctions.add(new Junction(JID,Name,Type,conn_roads));
        System.out.println("Junction added successfully");
        System.out.println();
        System.out.println("--------------------------");
    }

    public static void addRoad(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("Enter Road ID : ");
        Scanner input = new Scanner(System.in);
        int RID = input.nextInt();
        System.out.println("Enter Road Name : ");
        String Name = input.next();
        System.out.println("Enter Length : ");
        int Length = input.nextInt();

        Roads.add(new Road(RID,Name,Length));
        System.out.println("Road added successfully");
        System.out.println();
        System.out.println("--------------------------");
    }

    public static void listJunctions(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("List of Junctions : \n");
        for(int i = 0;i<Junctions.size();i++){
            System.out.print("Junction ID : ");
            System.out.println(Junctions.get(i).JunctionID);
            System.out.print("Junction Name : ");
            System.out.println(Junctions.get(i).JunctionName);
            System.out.print("Junction Type : ");
            System.out.println(Junctions.get(i).JunctionType);
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public static void listRoads(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("List of Roads : \n");
        for(int i = 0;i<Roads.size();i++){
            System.out.print("Road ID : ");
            System.out.println(Roads.get(i).RoadId);
            System.out.print("Road Name : ");
            System.out.println(Roads.get(i).RoadName);
            System.out.print("Road Length : ");
            System.out.println(Roads.get(i).Length);
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public static void deleteRoad(){
        System.out.println("--------------------------");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Road ID : ");
        int RID = input.nextInt();
        input.close();
        Road rd = return_road(RID);

        if(rd == null){
            System.err.println("Road does not exist");
        }
        else{
            Roads.remove(rd);
            System.out.println("Road Successfully deleted");
        }
        System.out.println();
        System.out.println("--------------------------");
    }

    public static void deleteJunction(){
        System.out.println("--------------------------");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Junction ID : ");
        int JID = input.nextInt();
        input.close();
        Junction jn = return_jn(JID);

        if(jn == null){
            System.err.println("Junction does not exist");
        }
        else{
            Junctions.remove(jn);
            System.out.println("Junction Successfully deleted");
        }
        System.out.println();
        System.out.println("--------------------------");
    }

    public static void addPoliceStation(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("Enter Station ID : ");
        Scanner input = new Scanner(System.in);
        int SID = input.nextInt();
        System.out.println("Enter Station Name : ");
        String Name = input.next();
        System.out.println("Enter Pin Code : ");
        int pinCode = input.nextInt();
        System.out.println("Enter Initial Number of Personnel : ");
        ArrayList<Traffic_Police> police = new ArrayList<>();
        int n = input.nextInt();
        int i = 0;
        while(i<n){
            /*System.out.println("Enter Police ID : ");
            int PID = input.nextInt();*/
            Traffic_Police police1 = addPolice();
            /*if(police1 == null){
                System.err.println("Personnel does not exist. Try again...");
            }
            else*/
            //{
                police.add(police1);
                i++;
            //}

        }

        System.out.println("Enter Number of Junctions Under Control : ");
        ArrayList<Junction> junctions = new ArrayList<>();
        int m = input.nextInt();
        i = 0;
        while(i<m){
            System.out.println("Enter Junction ID : ");
            int JID = input.nextInt();
            Junction jn = return_jn(JID);
            if(jn == null){
                System.out.println("Junction does not exist. Try again...");
            }
            else{
                junctions.add(jn);
                i++;
            }

        }

        input.close();
        PoliceStations.add(new Police_Station(SID,Name,police,junctions,pinCode));
        System.out.println("Police Station added successfully");
        System.out.println();
        System.out.println("--------------------------");
    }

    public static void deletePoliceStation(){
        System.out.println("--------------------------");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Police Station ID : ");
        int SID = input.nextInt();
        input.close();
        Police_Station ps = return_police_station(SID);

        if(ps == null){
            System.err.println("Police Station does not exist");
        }
        else{
            PoliceStations.remove(ps);
            System.out.println("Police Station Successfully deleted");
        }
        System.out.println();
        System.out.println("--------------------------");
    }

    public static Traffic_Police addPolice(){

        System.out.print("Enter Police ID : ");
        Scanner input = new Scanner(System.in);
        int PID = input.nextInt();
        System.out.print("Enter Name : ");
        String Name = input.next();
        System.out.print("Enter Age : ");
        int age = input.nextInt();
        System.out.print("Enter Salary : ");
        int salary = input.nextInt();
        System.out.print("Enter Years Of Experience : ");
        int yoe = input.nextInt();
        System.out.print("Enter Address : ");
        String address = input.next();
        input.close();
        return new Traffic_Police(PID,Name,age,salary,yoe,address);
    }

    public static void deletePolice(){
        System.out.println("--------------------------");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Police Station ID : ");
        int SID = input.nextInt();
        Police_Station ps = return_police_station(SID);
        if(ps == null){
            System.err.println("Police Station does not exist");
        }
        else{
            System.out.println("Enter Police ID : ");
            int pid = input.nextInt();
            Traffic_Police police = return_police(ps,pid);
            if(police == null){
                System.out.println("Traffic Police does not exist");
            }
            else{
                ps.Personnel.remove(police);
            }
            System.out.println("Police Successfully deleted");
        }
        System.out.println();
        System.out.println("--------------------------");

        input.close();

    }

    public static void listPolice(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.print("Enter Police Station ID : ");
        Scanner input = new Scanner(System.in);
        int SID = input.nextInt();

        Police_Station PS = return_police_station(SID);
        if(PS == null){
            System.err.println("Station Does Not Exist");
        }
        else {
            for(int i =0;i<PS.Personnel.size();i++){
                System.out.print("Police ID : ");
                System.out.println(PS.Personnel.get(i).PoliceID);
                System.out.print("Police Name : ");
                System.out.println(PS.Personnel.get(i).Name);
                System.out.println();
            }
        }
        System.out.println("--------------------------");

    }

    public static void listStations(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("List of Police Stations : \n");
        for(int i = 0;i<PoliceStations.size();i++){
            System.out.print("Police Station ID : ");
            System.out.println(PoliceStations.get(i).StationID);
            System.out.print("Name : ");
            System.out.println(PoliceStations.get(i).StationName);
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
