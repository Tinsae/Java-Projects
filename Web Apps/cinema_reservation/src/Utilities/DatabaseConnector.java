package Utilities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector  implements Serializable{

	
private static final long serialVersionUID = 1L;
public Connection con;
public Statement st;
	
	public void init()
	{		
		try
		{
		String uid = "root";
		String pwd = "";
		String db_name = "mormor";
		String url = "jdbc:mysql://localhost:3306/" + db_name;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, uid, pwd);
		st=con.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	public void destroy()
	{
		try {
			con.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
