package Minor;
import java.sql.SQLException;
import java.util.*;
public class SBI {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
 Scanner sc=new Scanner(System.in);
 System.out.println("*****WELCOME TO PROFILE*****");
 System.out.println("Enter Login:");
 String a=sc.next();
 String b="Login";
// ACCOUNT rs=new ACCOUNT ();
 
 if(a.equalsIgnoreCase(b))
 {
	 ACCOUNT ln=new ACCOUNT();
		ln.run();
 }

	}

}
