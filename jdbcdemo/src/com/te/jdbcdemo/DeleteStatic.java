package com.te.jdbcdemo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DeleteStatic {
   public static void main(String[] args) {
	   Connection con=null;
	   Statement stmt=null;
	try {
		//load the driver
		Class.forName("com.mysql.jdbc.Driver");
		FileInputStream fis=new FileInputStream("properties.properties");
		Properties prop=new Properties();
		prop.load(fis);
		//get connection
		con=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("pw"));
		stmt=con.createStatement();
		String query="delete from employeedata  where empid=4;";
		int row=stmt.executeUpdate(query);
		System.out.println(row+" row is deleted");
	} catch (Exception e) {
		System.out.println(e);
	}
	finally {
		try {
			if(con!=null) {
				 con.close();
			 }
			if(stmt!=null) {
				stmt.close();
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		 
	}
}
}
