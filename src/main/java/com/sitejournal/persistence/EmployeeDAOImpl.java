package com.sitejournal.persistence;

import com.sitejournal.data.Employee;
import com.sitejournal.data.EmployeeReview;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getId() == 0) {
            entityManager.persist(employee);
        }else {
            entityManager.merge(employee);
        }
        return employee;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        entityManager.remove(employee);
    }

    @Override
    public void deleteEmployeeById(long id) {
        Employee findEmployee = entityManager.find(Employee.class,id);
        entityManager.remove(findEmployee);
    }


    @Override
    public Employee updateEmployee(Employee employee) {
        entityManager.merge(employee);
        return employee;
    }

    @Override
    public Employee updateEmployeeById(long id) {
        Employee findEmployeeToUpdate = entityManager.find(Employee.class,id);
        entityManager.merge(findEmployeeToUpdate);
        return findEmployeeToUpdate;
    }

    @Override
    public Employee findEmployeeById(long id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> getE = entityManager.createQuery("SELECT a FROM Employee a",Employee.class).getResultList();
        return getE;
    }

    @Override
    public void addEmployeeReview(long employeeId, EmployeeReview review) {
      Employee employee = findEmployeeById(employeeId);
      review.setEmployee(employee);
      employee.addReview(review);
    }
}
