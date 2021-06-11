package com.te.dao;

public class GetDAOImpl {
   String type="jdbc";
   public EmployeeDAO getDAOImpl() {
	   if(type.equalsIgnoreCase("jdbc")) {
		   return new EmployeeDAOJDBCImpl();
	   }else if(type.equalsIgnoreCase("hibernate")) {
		   return new EmployeeDAOJDBCImpl();
	   }else if(type.equalsIgnoreCase("spring")) {
		   return new EmployeeDAOJDBCImpl();
	   }
	   return null;
   }
}
