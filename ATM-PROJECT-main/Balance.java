package Minor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Balance {
	public static void getBal(int pw) throws ClassNotFoundException, SQLException {
		System.out.println("**BALANCE**");
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/project";
		String user="root";
		String psw="mysql123";
		Connection co=DriverManager.getConnection(url,user,psw);
		Statement s=co.createStatement();
		ResultSet re=s.executeQuery("select * from register where Ac_id='"+pw+"';");
		re.next();
		int a=re.getInt("Amount");
		System.out.println("Amount in your Account:"+a);
	}

}
