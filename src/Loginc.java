
import java.util.ArrayList;
import java.util.Scanner;
public class Loginc {

	static ArrayList<User> userlist = new ArrayList<User>();

	static int status = 0;
	static void modify(String chu)
	{
		Scanner s = new Scanner(System.in);
		int flag = -1;
		int x = search(chu);
		System.out.println("Modify username (1) or (2) password (3) authorization ?");
		int c = Integer.parseInt(s.nextLine());
		String y = null;
		switch(c)
		{
			case 1: System.out.println("Enter new username");
					y = s.nextLine();
					if(search(y)==-1)
					{
						if(y.length()>=6) {
							flag = 1;
						}
					}
					break;
			case 2: System.out.println("Enter new password");
					if(y.length()>=6)
					{
						String numRegex   = ".*[0-9].*";
						String alphaRegex = ".*[A-Z].*";
							if (y.matches(numRegex) && y.matches(alphaRegex)) 
							{
								flag = 1;
							}
					}
					break;
			case 3: try {
				        int d = Integer.parseInt(y);
				    } catch (NumberFormatException nfe) {
				        flag = -1;
				    }
				    flag = 1;
				    break;
		}
		if(flag == 1) {
			userlist.get(x).modify(c, y);
			}
	}
	static void delete(String chu)
	{
		// PLEASE MAKE SURE USERNAME EXISTS BEFORE CALLING THIS FUNCTION !!
		int x = search(chu);
		userlist.remove(x);
	}
	
	static int search(String chu)
	{
		for(int i = 0; i < userlist.size(); i++)
		{
			if(userlist.get(i).getusn().equals(chu))
					return i;
		}
		return -1;
	}
	static boolean signin(String chu, String chp)
	{
		int x= search(chu);
		if(x!=-1){
			if(userlist.get(x).getpwd().equals(userlist.get(x).hash(chp)))
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	static boolean signup(String chu, String chp)
	{
		if(chu!= null && chp!= null)
		{
			if(chu.length()>=6 && chp.length()>=6)
			{
				if(search(chu)==-1)
				{
					String numRegex   = ".*[0-9].*";
					String alphaRegex = ".*[A-Z].*";

					if (chp.matches(numRegex) && chp.matches(alphaRegex)) 
					{
						userlist.add(new User(chu,chp,0));
						System.out.println("+------------------------------------------------+");
						System.out.println("|       USER ACCOUNT CREATED SUCCESSFULLY!       |");
						System.out.println("+------------------------------------------------+");
						return true;
					}
					else {

						System.err.println("+------------------------------------------------+");
						System.err.println("|  PASSWORD NEEDS TO BE LONGER THAN SIX DIGITS   |");
						System.err.println("|AND MUST CONTAIN NUMBERS AND UPPERCASE ALPHABETS|");
						System.err.println("+------------------------------------------------+");
						return false;
					}

				}
				else {

					System.err.println("+------------------------------------------------+");
					System.err.println("|      USERNAME ALREADY IN USE, TRY AGAIN.       |");
					System.err.println("+------------------------------------------------+");
					return false;
					}
			}
			else {

				System.err.println("+------------------------------------------------+");
				System.err.println("|           PASSWORD AND USERNAME                |");
				System.err.println("|     NEEDS TO BE LONGER THAN SIX DIGITS         |");
				System.err.println("+------------------------------------------------+");
				return false;
				}
		}
		else {

			System.err.println("+------------------------------------------------+");
			System.err.println("|              PASSWORD AND USERNAME             |");
			System.err.println("|                 CANNOT BE NULL                 |");
			System.err.println("+------------------------------------------------+");
			return false;
			}
	}
	public static void Login()
	{
		Scanner s = new Scanner(System.in);
		listusers(); //temporary
		System.out.println("    +---------------------------------------+");
		System.out.println("    |  WELCOME! PLEASE LOGIN IN OR SIGN UP  |");
		System.out.println("    +---------------------------------------+");
		
		System.out.println("+----------------+                +-----------------+ ");
		System.out.println("|Enter 1 to login|                |Enter 2 to signup|");
		System.out.println("+----------------+                +-----------------+ ");
		System.out.println("===================================================== ");
		int c = Integer.parseInt(s.nextLine());
		if(c == 1 || c==2)
		{
			System.out.println("+------------------------------------------------+");
			System.out.println("|             ENTER USERNAME                     |");
			System.out.println("+------------------------------------------------+");
			String x = s.nextLine();
			System.out.println("+------------------------------------------------+");
			System.out.println("|           ENTER PASSWORD                       |");
			System.out.println("+------------------------------------------------+");
			String y = s.nextLine();
			if(c==1)
			{
				boolean z = signin(x,y);
				if(z)
				{
					System.out.println("+------------------------------------------------+");
					System.out.println("|                LOGIN SUCCESSFULL!              |");
					System.out.println("+------------------------------------------------+");
					status = 1;
				}
				else {
					System.err.println("+------------------------------------------------+");
					System.err.println("|          INVALID USERNAME OR PASSWORD          |");
					System.err.println("+------------------------------------------------+");
					status = 0;
				}
			}
			else if(c == 2)
		{
			boolean ret = signup(x,y);

		}
		else {
			System.out.println("+------------------------------------------------+");
			System.err.println("|          INVALID INPUT. TRY AGAIN.             |");
			System.out.println("+------------------------------------------------+");
		}
		}
		
	}

	public static void listusers()
	{
		System.out.println("--------------------------");
		System.out.println();
		System.out.println("List of Users : \n");
		for(int i = 0;i<userlist.size();i++){
			System.out.print("Username : ");
			System.out.println(userlist.get(i).username);
			System.out.print("Password : ");
			System.out.println(userlist.get(i).password);
			System.out.print("Authorization : ");
			System.out.println(userlist.get(i).authorization);
			System.out.println();
		}
	}

}
