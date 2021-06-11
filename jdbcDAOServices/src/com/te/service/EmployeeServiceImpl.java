package com.te.service;

import com.te.bean.EmployeeData;
import com.te.dao.EmployeeDAO;
import com.te.dao.GetDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{
   GetDAOImpl daoImpl=new GetDAOImpl();
   EmployeeDAO dao=daoImpl.getDAOImpl();
@Override
public EmployeeData getSingleRecord(int id) {
	if(id<0) {
		return null;
	}else {
		System.out.println("employee service layer");
		return dao.getSingleRecord(id);
	}
	
}
@Override
public void getAllRecords() {
	System.out.println("Fetching all the records");
	
}
@Override
public void insertRecord(EmployeeData a) {
	System.out.println("Inserted");
	
}
   
}
