package com.demo.employee.controller;

import com.demo.employee.api.controller.EmployeeResource;
import com.demo.employee.api.model.Employee;
import com.demo.employee.api.model.GetAllEmployeeResponse;
import com.demo.employee.api.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
@Slf4j
public class EmployeeResourceImpl implements EmployeeResource {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeResourceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {
        log.info("Fetching Employee for id {}", id);
        Employee employee = this.employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> createEmployee(Employee employee) {
        Employee createdEmployee = this.employeeService.createEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteEmployee(String id) {
        String deletedEmployee = this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>(deletedEmployee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(String id, Employee employee) {
        Employee updatedEmployee = this.employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<GetAllEmployeeResponse> getAllEmployees(String sort , String filter) {
        GetAllEmployeeResponse allEmployees = this.employeeService.getAllEmployees(sort, filter);
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }
}
