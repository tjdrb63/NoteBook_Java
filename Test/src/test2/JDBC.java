package test2;

import java.io.*;
import java.sql.*;
import java.util.*;

public class JDBC {

	public static void main(String[] args) throws Exception{
		
			Properties dbconfig = new Properties();
			File file = new File("dbconfig.props");
			FileReader reader = new FileReader(file);
			dbconfig.load(reader);
			
			String driverClassName = dbconfig.getProperty("driverClassName");
			String Url = dbconfig.getProperty("Url");
			String User = dbconfig.getProperty("userName");
			String PW = dbconfig.getProperty("userPassword");
			
		//	System.out.println(driverClassName+Url+User+PW);
			
			
		
			Connection con =null;
				Class.forName(driverClassName);
				con = DriverManager.getConnection(Url,User,PW);
				PreparedStatement pstmt = con.prepareStatement("select * from books");
				ResultSet rs= pstmt.executeQuery();
				while(rs.next()) {
					String Key = rs.getString("title");
					System.out.println(Key);
				}

	}
	
}
