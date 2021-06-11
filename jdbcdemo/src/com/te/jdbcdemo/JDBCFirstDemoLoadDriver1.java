package com.te.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCFirstDemoLoadDriver1 {
    public static void main(String[] args) {
    	Connection con=null;
    	Statement stmt=null;
    	ResultSet rs=null;
	try {
		//Load the driver
		com.mysql.jdbc.Driver driver=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	//get connection
	try {
		String dburl="jdbc:mysql://localhost:3317/employee_info?user=root&password=root";
		con=DriverManager.getConnection(dburl);
		if(con!=null) {
			System.out.println("Connection established");
		}
	} catch (SQLException e) {
		
			e.printStackTrace();
	}
	//issue the sql query
	try {
		String query="select * from employee;";
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		System.out.println("Execute query");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		while(rs.next()) {
			System.out.println(rs.getInt("empid"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("sal"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
			try {
				if(con!=null) {
				con.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	
	}
}
