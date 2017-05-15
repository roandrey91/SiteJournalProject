package com.sitejournal.services;

import com.sitejournal.data.Employee;
import com.sitejournal.data.EmployeeReview;
import com.sitejournal.persistence.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    public Employee findEmployeeById(long id){
        return employeeDAO.findEmployeeById(id);
    }

    @Transactional
    public Employee saveEmployee(Employee employee){
        return employeeDAO.saveEmployee(employee);
    }

    @Transactional
    public Employee updateEmployee(Employee employee){
        return employeeDAO.updateEmployee(employee);
    }

    @Transactional
    public Employee updateEmployeeById(long id){
        return employeeDAO.updateEmployeeById(id);
    }

    @Transactional
    public void deleteEmployee(Employee employee){
        employeeDAO.deleteEmployee(employee);
    }

    @Transactional
    public void deleteEmployeeById(long id){
        employeeDAO.deleteEmployeeById(id);
    }

    @Transactional
    public List<Employee> getEmployees(){
        return employeeDAO.getEmployees();
    }

    @Transactional
    public void addEmployeeReview(long employeeId, EmployeeReview employeeReview){
        employeeDAO.addEmployeeReview(employeeId, employeeReview);
    }







}
