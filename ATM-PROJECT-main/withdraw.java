package Minor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class withdraw {
	public static void getMoney(int pw) throws SQLException, ClassNotFoundException
{
		

		System.out.println("Withdraw");
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Enter the Amount to Withrwal:");
		int wd=sc.nextInt();
	
			int finalam=0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/project";
			String user="root";
			String psw="mysql123";
			
			Connection co=DriverManager.getConnection(url,user,psw);
			Statement s=co.createStatement();
			ResultSet re=s.executeQuery("select * from register where Ac_id='"+pw+"';");
	
		 re.next();
			 int am=re.getInt("Amount");
	 System.out.println("The amount on your Account is:"+am);
		
		 if(am>=wd)
		 {
			 finalam=am-wd;
			 PreparedStatement ps= co.prepareStatement("update register set  amount=? where ac_id=?;");
					ps.setInt(2, pw);
					ps.setInt(1,finalam);
					 int row=ps.executeUpdate();
					 if(row>0) {System.out.println("");
					
						 System.out.println("UPDATION DONE");
						 							
						 }
						 else
						 {
							
								
							 System.out.println("Try again.");
						 
								}
						 System.out.println("The amount on your Account is:"+finalam);
			
		 }
		 else
		 {
			 System.out.println("Insufficent Fund.");
		 }
			
}
}