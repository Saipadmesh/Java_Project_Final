package semproject;
import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
		
	    String username;
	    String password;
	    int authorization;
	   public User(String usn,String pwd, int auth){
	    	username = usn;
	       	authorization = auth;
	       	password = hash(pwd);
		}
	 	   
	public String hash(String plaintext)
	{
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(plaintext.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			String hashtext = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32 chars.
			while(hashtext.length() < 32 ){
			  hashtext = "0"+hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	
	public String getusn()
	{
		return username;
	}
	public String getpwd()
	{
		return password;
	}
	
	public int getauth()
	{
		return authorization;
	}
	public void modify(int a, String y)
	{
		switch(a)
		{
		case 1: username = y;
		break;
		case 2: password = hash(y);
		break;
		case 3: authorization = Integer.parseInt(y);
		break;
		}
	}
	public static void main(String args[])
	  {
		  Scanner s = new Scanner(System.in);
		  System.out.println("\t\t\t\t\t  _______         __  __ _                             \r\n"
		  		+ "\t\t\t\t\t |__   __|       / _|/ _(_)                            \r\n"
		  		+ "\t\t\t\t\t    | |_ __ __ _| |_| |_ _  ___                        \r\n"
		  		+ "\t\t\t\t\t    | | '__/ _` |  _|  _| |/ __|                       \r\n"
		  		+ "\t\t\t\t\t    | | | | (_| | | | | | | (__                        \r\n"
		  		+ "\t\t\t\t\t    |_|_|  \\__,_|_| |_| |_|\\___|        _              \r\n"
		  		+ "\t\t\t\t\t                       (_) |           (_)             \r\n"
		  		+ "\t\t\t\t\t  _ __ ___   ___  _ __  _| |_ ___  _ __ _ _ __   __ _  \r\n"
		  		+ "\t\t\t\t\t | '_ ` _ \\ / _ \\| '_ \\| | __/ _ \\| '__| | '_ \\ / _` | \r\n"
		  		+ "\t\t\t\t\t | | | | | | (_) | | | | | || (_) | |  | | | | | (_| | \r\n"
		  		+ "\t\t\t\t\t |_|_|_| |_|\\___/|_| |_|_|\\__\\___/|_|  |_|_| |_|\\__, | \r\n"
		  		+ "\t\t\t\t\t  / ____|         | |                            __/ | \r\n"
		  		+ "\t\t\t\t\t | (___  _   _ ___| |_ ___ _ __ ___             |___/  \r\n"
		  		+ "\t\t\t\t\t  \\___ \\| | | / __| __/ _ \\ '_ ` _ \\                   \r\n"
		  		+ "\t\t\t\t\t  ____) | |_| \\__ \\ ||  __/ | | | | |                  \r\n"
		  		+ "\t\t\t\t\t |_____/ \\__, |___/\\__\\___|_| |_| |_|                  \r\n"
		  		+ "\t\t\t\t\t          __/ |                                        \r\n"
		  		+ "\t\t\t\t\t         |___/ ");
		  String a,b;
		  System.out.println("get u name");
		  a = s.nextLine();
		  System.out.println("get p");
		  b = s.nextLine();

		  if(a.length()>=6)
		  {
			  /*call function in login to check if uname exists*/
			  /*if it does, ask again. make the 
			   * uname checking in array list as the cond
			   * for the while loop and keep asking for it.*/
			  if(b != null)
			  {
//				  Matcher m = p.matcher(b);
//				  if(m.matches())
				  if(b.length()>=8)
				  {
					  User u1 = new User(a,b,0);
					  System.out.println(u1.getpwd());
				  }
				  else System.err.print("no <3");
			  }
			  else System.err.print("no <3");
		  }
		  else System.err.print("no <3");  
	  }
}
