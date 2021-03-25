package com.demo.employee.dao;

import com.demo.employee.api.model.Employee;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface EmployeeDao {

    /**
     * Fetches an Employee Record from DB and returns after Transformation.
     *
     * @param id
     * @return {@link Employee}
     * @throws EntityNotFoundException
     */
    Employee getEmployeeById(Integer id) throws EntityNotFoundException;

    /**
     * Transforms the Employee Request into EmployeeEntity and saves into DB.
     *
     * @param employee {@link Employee}
     * @return {@link Employee}
     */
    Employee createEmployee(Employee employee);

    void deleteEmployee(Integer id);

    Employee updateEmployee(Integer id, Employee employee) throws EntityNotFoundException;

    List<Employee> getAllEmployee(String filter);
}
