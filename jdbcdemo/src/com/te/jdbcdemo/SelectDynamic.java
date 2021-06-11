package com.te.jdbcdemo;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class SelectDynamic {
   public static void main(String[] args) {
	   Connection con=null;
	   PreparedStatement prpd=null;
	   ResultSet rs=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		FileInputStream fis=new FileInputStream("properties.properties");
		Properties prop=new Properties();
		prop.load(fis);
		con=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("pw"));
		String query="select * from employeedata where empid=?";
		prpd=con.prepareStatement(query);
		prpd.setInt(1,Integer.parseInt(args[0]));
		rs=prpd.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getDate(4));
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
