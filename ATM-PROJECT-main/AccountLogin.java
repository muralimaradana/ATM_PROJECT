package Minor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AccountLogin  extends SBI{

	public static void run() throws ClassNotFoundException, SQLException {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter AccountID:");
		int Ac=sc.nextInt();
		System.out.println("Enter Password:");
		int pw =sc.nextInt();
Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/Naritech";
		String user="root";
		String psw="mysql123";
	//	Connection com=DriverManager.getConnection("jdbc:mysql://localhost:3306/Naritech","root","mysql123");
		Connection com=DriverManager.getConnection(url,user,psw);
		//statement object creation
		Statement s=com.createStatement();
		ResultSet rs=s.executeQuery("select * from Hr;");
		rs.next();
		
		System.out.println("hello");
	}
	
}
