package Minor;

import java.util.Scanner;
import java.sql.*;

public class ACCOUNT extends SBI {

	public static void run() throws ClassNotFoundException, SQLException{
		//System.out.println("Name");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter AccountID:");
		int Ac=sc.nextInt();
		System.out.println("Enter Password:");
		int pw =sc.nextInt();
		
Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/project";
		String user="root";
		String psw="mysql123";
	//	Connection com=DriverManager.getConnection("jdbc:mysql://localhost:3306/Naritech","root","mysql123");
		Connection co=DriverManager.getConnection(url,user,psw);
		Statement s=co.createStatement();
		//System.out.println("hello");
		ResultSet re=s.executeQuery("select * from register where Ac_id='"+Ac+"';");
		//System.out.println("hii");
		int ps=0;
		while(re.next()) {
			ps=re.getInt("Pswd");
		}
		if(pw==ps) {
			while(true)
			{
				System.out.println("*****WELCOME TO BANK*****");
				System.out.println("1.Balance");
				System.out.println("2.Withdraw");
				System.out.println("3.Deposit");
				System.out.println("4.Change Password");
				System.out.println("5.Exit");
				System.out.println("Enter the Activity No:");
				int op=sc.nextInt();
				Balance bal=new Balance();
				withdraw wd=new withdraw();
				Deposit d=new Deposit();
				changepsw cp=new changepsw();
				switch(op)
				{
				case 1:bal.getBal(Ac);
				break;
				case 2:wd.getMoney(Ac);
				break;
				case 3:d.putMoney(Ac);
				break;
				case 4:cp.chan(Ac);
				break;
				case 5:System.out.println("**THANKYOU**");
				}
				
				
				
			}
		}
		else {
			System.out.println("Password is Wrong");
		}
	}

	}
	


