package com.te.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.te.bean.EmployeeData;

public class EmployeeDAOJDBCImpl implements EmployeeDAO{

	@Override
	public EmployeeData getSingleRecord(int id) {
		EmployeeData empData=new EmployeeData();
		try {
			String dburl="jdbc:mysql://localhost:3317/employee_info";
			Connection con=DriverManager.getConnection(dburl,"root","root");
			Statement stmt=con.createStatement();
			String query="select * from employee where empid="+id+";";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
      		empData.setEmpid(rs.getInt("empid"));
     		empData.setName(rs.getString("name"));
     		empData.setSalary(rs.getInt("sal"));
     		empData.setDoj(rs.getDate("doj"));
			}
		} catch (Exception e) {
			
		}
		return empData;
	}

	@Override
	public void getAllRecords() {
		System.out.println("Get all records");
		
	}

	@Override
	public void insertRecord(EmployeeData a) {
		System.out.println("Insert all the records");
		
	}

}
