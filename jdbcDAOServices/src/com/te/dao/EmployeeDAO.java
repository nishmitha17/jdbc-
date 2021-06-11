package com.te.dao;

import com.te.bean.EmployeeData;

public interface EmployeeDAO {
    public EmployeeData getSingleRecord(int id);
    public void getAllRecords();
    public void insertRecord(EmployeeData a);
}
