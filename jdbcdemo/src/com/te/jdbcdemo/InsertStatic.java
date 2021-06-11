package com.te.jdbcdemo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class InsertStatic {
    public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
    	try {
    		//load driver
			Class.forName("com.mysql.jdbc.Driver");
			//get connection
		    FileInputStream fis=new FileInputStream("properties.properties");
		    Properties prop=new Properties();
		    prop.load(fis);
		    con=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("pw"));
		    stmt=con.createStatement();
		    String query="insert into employeedata values(4,'yamini',20000,'2021-06-10');";
		    int row=stmt.executeUpdate(query);
		    System.out.println(row+" row inserted");
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
    			
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
    		
    	}
	}
}
