package com.te.jdbcdemo;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
  private String name;
  private int empid;
  private int salary;
  private Date doj;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public Date getDoj() {
	return doj;
}
public void setDoj(Date doj) {
	this.doj = doj;
}
public Employee() {
	
}
public Employee(String name, int empid, int salary, Date doj) {
	super();
	this.name = name;
	this.empid = empid;
	this.salary = salary;
	this.doj = doj;
}
  
}
