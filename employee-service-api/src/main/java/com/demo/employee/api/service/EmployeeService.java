package com.demo.employee.api.service;

import com.demo.employee.api.model.Employee;
import com.demo.employee.api.model.GetAllEmployeeResponse;

public interface EmployeeService {

    /**
     * Get an Employee by ID.
     *
     * @param id
     * @return {@link Employee}
     */
    Employee getEmployeeById(String id);

    /**
     * Creates a new Employee with the given details.
     *
     * @param employee {@link Employee}
     * @return {@link Employee}
     */
    Employee createEmployee(Employee employee);


    String deleteEmployee(String id);

    Employee updateEmployee(String id, Employee employee);

    GetAllEmployeeResponse getAllEmployees(String sort, String filter);
}
