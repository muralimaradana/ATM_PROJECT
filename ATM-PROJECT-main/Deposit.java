package Minor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Deposit {
	public static void putMoney(int pw)throws SQLException, ClassNotFoundException  {
		System.out.println("WELCOME TO DEPOSIT");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the Amount to Deposit:");
		int Dp=sc.nextInt();
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
		 if(Dp>0)
		 {
			 finalam=am+Dp;
			 PreparedStatement ps= co.prepareStatement("update register set  amount=? where Ac_id=?;");
					ps.setInt(2, pw);
					ps.setInt(1,finalam);
					 int row=ps.executeUpdate();
					 if(row>0) {
						 System.out.println("UPDATION DONE");
						 }
						 else
						 {
							 System.out.println("SomeThing Went wrong Please try again.");
						 }
		 System.out.println("The amount on your Account is:"+finalam);
		 }
		 else
		 {
			 System.out.println("Insufficent Fund.");
		 }
			
	}
}