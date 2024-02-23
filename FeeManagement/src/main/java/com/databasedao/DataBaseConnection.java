package com.databasedao;

import java.sql.Connection;
import java.sql.DriverManager;



public class DataBaseConnection {
	 private static final String jdbcurl = "jdbc:oracle:thin:@//Gipsy:1521/orcl";
	 private static final String db_username = "KishoreDB";
	 private static final String db_password = "kishore";
	
	public static Connection getcon()
	{
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(jdbcurl,db_username,db_password);
		}
		catch(Exception ex)
		{System.out.println(ex);}
		return con;
	
	}
	

}
