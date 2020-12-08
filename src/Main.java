import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


		Loginc.listusers();




        Scanner input = new Scanner(System.in);
        int c1,c2;
        System.out.println("\t\t\t\t\t  ___         _  _ _                             \r\n"
                + "\t\t\t\t\t |_   _|       / |/ _()                            \r\n"
                + "\t\t\t\t\t    | |_ _ _ | || |_ _  _                        \r\n"
                + "\t\t\t\t\t    | | '_/ _` |  _|  _| |/ _|                       \r\n"
                + "\t\t\t\t\t    | | | | (| | | | | | | (_                        \r\n"
                + "\t\t\t\t\t    |||  \\_,|| || ||\\__|        _              \r\n"
                + "\t\t\t\t\t                       () |           ()             \r\n"
                + "\t\t\t\t\t  _ _ __   _  _ _  _| | _  _ _ _ _ _   __ _  \r\n"
                + "\t\t\t\t\t | '_ ` _ \\ / _ \\| '_ \\| | _/ _ \\| '| | ' \\ / _` | \r\n"
                + "\t\t\t\t\t | | | | | | () | | | | | || () | |  | | | | | (_| | \r\n"
                + "\t\t\t\t\t |||| ||\\__/|| |||\\_\\_/||  ||| ||\\_, | \r\n"
                + "\t\t\t\t\t  / _|         | |                            _/ | \r\n"
                + "\t\t\t\t\t | (_  _   _ _| |_ _ _ _ __             |_/  \r\n"
                + "\t\t\t\t\t  \\__ \\| | | / _| _/ _ \\ ' ` _ \\                   \r\n"
                + "\t\t\t\t\t  _) | || \\__ \\ ||  __/ | | | | |                  \r\n"
                + "\t\t\t\t\t |__/ \\, |_/\\\\_|| || ||                  \r\n"
                + "\t\t\t\t\t          __/ |                                        \r\n"
                + "\t\t\t\t\t         |_/ ");

		  LogOp.addVehicle();
		  LogOp.addVehicle();
		  LogOp.addVehicle();
		  

        System.out.println(LogOp.vehicle.size());

        //Loginc.Login();

        //if (Loginc.status==1)
        {
            //TRAFFIC POLICE
            System.out.println("+---------------------------------+                +---------------------------------+ ");
            System.out.println("|Enter 1 for ACCIDENT LOG         |                |Enter 2 for TRAFFIC VIOLATION LOG|");
            System.out.println("+---------------------------------+                +---------------------------------+ ");
            System.out.println("======================================================================================= ");
            c1 = input.nextInt();
            if(c1 ==1||c1 ==2)
            {
                System.out.println("+-------------------------------------------+");
                System.out.println("|		1. DISPLAY LOG		    |");
                System.out.println("+-------------------------------------------+");
                System.out.println("+-------------------------------------------+");
                System.out.println("|		2. ADD LOG		    |");
                System.out.println("+-------------------------------------------+");
                System.out.println("+-------------------------------------------+");
                System.out.println("|		3. DELETE LOG		    |");
                System.out.println("+-------------------------------------------+");
                c2 = input.nextInt();
                if(c1==1)
                {
                    switch(c2)
                    {
                        case 1: LogOp.listAccident();
                            break;
                        case 2: LogOp.addAccident();
                            break;
                        case 3: LogOp.deleteAccident();
                            break;
                        default: System.out.println("INVALID INPUT");
                    }

                }
                else
                {
                    switch(c2)
                    {
                        case 1: LogOp.listViolation();
                            break;
                        case 2: LogOp.addViolation();
                            break;
                        case 3: LogOp.deleteViolation();
                            break;
                        default: System.out.println("INVALID INPUT");
                    }
                }
            }
            else
                System.out.println("INVALID INPUT");



            //PENALTY PAY
            System.err.println("+--------------------------+");
            System.err.println("|     CHECK VIOLATION      |");
            System.err.println("+--------------------------+");
            LogOp.CheckViolation();

        }








//input.close();
    }
}
