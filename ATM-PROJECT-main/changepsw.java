package Minor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class changepsw {
	public static void chan(int pw) throws ClassNotFoundException, SQLException  {
		System.out.println("Change");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Current Password:");
		int p=sc.nextInt();
		System.out.println("Enter New Password:");
		int s=sc.nextInt();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/project";
		String user="root";
		String psw="mysql123";
		Connection co=DriverManager.getConnection(url,user,psw);
		//Statement s=co.createStatement();
		//ResultSet re=s.executeQuery("select * from register where Ac_id='"+AC+"';");
		PreparedStatement ps=co.prepareStatement("update register set pswd=? where Ac_id=?;");
		ps.setInt(1, s);
		ps.setInt(2, pw);
		int r=ps.executeUpdate();
		if(r>0) {
			System.err.println("UPDATION DONE");
		}
		else {
			System.out.println("Try Again");
		}
		System.err.println("PASSWORD SUCCESSFULLY CHANGED");
		
	}

}
