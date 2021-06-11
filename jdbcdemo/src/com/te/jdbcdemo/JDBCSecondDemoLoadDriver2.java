package com.te.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSecondDemoLoadDriver2 {
    public static void main(String[] args) {
    	Connection con=null;
    	Statement stmt=null;
		try {
			//1.load driver
			Class.forName("com.mysql.jdbc.Driver");
			//2.get connection
			String bsurl="jdbc:mysql://localhost:3317/employee_info";
			con=DriverManager.getConnection(bsurl,"root","root");
			//3.issue queries
			String query="insert into employeedata values(2,'jinshi',25000,'2021-06-19');";
			stmt=con.createStatement();
			int row=stmt.executeUpdate(query);
			System.out.println(row+" rows are affected ");
			
		} catch (Exception e) {
			
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
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
}
