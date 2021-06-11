package com.te.jdbcdemo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DeleteDynamic {
   public static void main(String[] args) {
	   Connection con=null;
	   PreparedStatement prpd=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		FileInputStream fis=new FileInputStream("properties.properties");
		Properties prop=new Properties();
		prop.load(fis);
		con=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("pw"));
		String query="delete from employeeData where empid=?;";
		prpd=con.prepareStatement(query);
		prpd.setInt(1,Integer.parseInt(args[0]));
		int row=prpd.executeUpdate();
		System.out.println(row+" row is deleted");
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
