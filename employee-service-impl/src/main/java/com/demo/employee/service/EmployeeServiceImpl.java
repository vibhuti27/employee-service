package com.demo.employee.service;

import com.demo.employee.api.model.Employee;
import com.demo.employee.api.model.GetAllEmployeeResponse;
import com.demo.employee.api.service.EmployeeService;
import com.demo.employee.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return this.employeeDao.getEmployeeById(Integer.parseInt(id));
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return this.employeeDao.createEmployee(employee);
    }

    @Override
    public String deleteEmployee(String id) {
        this.employeeDao.deleteEmployee(Integer.parseInt(id));
        String result = "Employee with id " + id + " deleted successfully";
        return result;
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
        return this.employeeDao.updateEmployee(Integer.parseInt(id), employee);
    }

    @Override
    public GetAllEmployeeResponse getAllEmployees(String sort, String filter) {
        List<Employee> allEmployee = this.employeeDao.getAllEmployee(filter);
        if(sort.equals("DESC")) {
            Comparator<Employee> comparator = (e1, e2) -> e2.getId() - e1.getId();
            Collections.sort(allEmployee, comparator);
            return new GetAllEmployeeResponse(allEmployee, allEmployee.size());
        }
        return new GetAllEmployeeResponse(allEmployee, allEmployee.size());
    }
}