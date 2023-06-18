package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    public abstract List<Employee> getEmployee();


    List<Employee> getEmployeePaging(int pageNumber, int pageSize);

    Employee saveEmployee(Employee employee);
    Employee getSingleEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);
    List<Employee> getEmployeeByNameAndLocation(String name,String location);
    List<Employee> getEmployeeByKeyword(String name);
}
