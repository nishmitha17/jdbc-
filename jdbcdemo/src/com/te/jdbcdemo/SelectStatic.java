package com.te.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectStatic {
    public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		Employee emp=new Employee();
    	try {
    		//load driver
			Class.forName("com.mysql.jdbc.Driver");
			//get connection
		    String dburl="jdbc:mysql://localhost:3317/employee_info";
		    con=DriverManager.getConnection(dburl,"root","root");
		    stmt=con.createStatement();
		    String query="select * from employeedata where empid=1";
		    rs=stmt.executeQuery(query);
		    while(rs.next()) {
		    	emp.setEmpid(rs.getInt("empid"));
		    	emp.setName(rs.getString("name"));
		    	emp.setSalary(rs.getInt("salary"));
		    	emp.setDoj(rs.getDate("doj"));
		    }
		    System.out.println(emp.getEmpid()+" "+emp.getName()+" "+emp.getSalary()+" "+emp.getDoj());
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
    			if(rs!=null) {
        			rs.close();
        		}
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
    		
    	}
	}
}
