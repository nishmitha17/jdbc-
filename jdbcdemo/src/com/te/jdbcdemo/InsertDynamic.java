package com.te.jdbcdemo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class InsertDynamic {
   public static void main(String[] args) {
	   Connection con=null;
	   PreparedStatement prpd=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		FileInputStream fis=new FileInputStream("properties.properties");
		Properties prop=new Properties();
		prop.load(fis);
		con=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("pw"));
		String query="insert into employeeData values(?,?,?,?)";
		prpd=con.prepareStatement(query);
		prpd.setInt(1,Integer.parseInt(args[0]));
		prpd.setString(2,args[1]);
		prpd.setInt(3,Integer.parseInt(args[2]));
		prpd.setDate(4,Date.valueOf(args[3]));
		int row=prpd.executeUpdate();
		System.out.println(row+" row is inserted");
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
