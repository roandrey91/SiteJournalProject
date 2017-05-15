package com.sitejournal.persistence;

import com.sitejournal.data.Employee;
import com.sitejournal.data.EmployeeReview;

import java.util.List;


public interface EmployeeDAO {

    /**
     * @author Muresan Andrei
     * @param employee
     * Save Employee in db.
     * */
    Employee saveEmployee(Employee employee);

    /**
     * @author Muresan Andrei
     * @param employee
     * Delete Employee from db.
     * */
    void deleteEmployee(Employee employee);

    /**
     * @author Muresan Andrei
     * @param id
     * Delete Employee by id param from db.
     * */
    void deleteEmployeeById(long id);

    /**
     * @author Muresan Andrei
     * @param employee
     * Update Employee in db.
     * */
    Employee updateEmployee(Employee employee);

    /**
     * @author Muresan Andrei
     * @param id
     * Update Employee in db by using id param.
     * */
    Employee updateEmployeeById(long id);

    /**
     * @author Muresan Andrei
     * @param id
     * Find Employee by using param id.
     * */
    Employee findEmployeeById(long id);

    /**
     * @author Muresan Andrei
     * Get all Employee from db.
     * */
    List<Employee> getEmployees();

    /**
     * @author Muresan Andrei
     * @param review
     * @param employeeId
     * Add Employee an EmployeeReview and add in db.
     * */
    void addEmployeeReview(long employeeId, EmployeeReview review);
}
