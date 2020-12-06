import java.util.ArrayList;

public class Junction {
    int JunctionID;
    String JunctionName;
    String JunctionType;
    ArrayList<Road> Con_Roads = new ArrayList<>();

    public Junction(int junctionID, String junctionName, String junctionType, ArrayList<Road> con_Roads) {
        JunctionID = junctionID;
        JunctionName = junctionName;
        JunctionType = junctionType;
        Con_Roads = con_Roads;
    }

    public int getJunctionID() {
        return JunctionID;
    }

    public String getJunctionName() {
        return JunctionName;
    }

    public String getJunctionType() {
        return JunctionType;
    }

    public ArrayList<Road> getCon_Roads() {
        return Con_Roads;
    }
}
