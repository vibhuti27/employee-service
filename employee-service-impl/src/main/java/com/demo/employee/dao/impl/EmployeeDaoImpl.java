package com.demo.employee.dao.impl;

import com.demo.employee.api.model.Employee;
import com.demo.employee.dao.EmployeeDao;
import com.demo.employee.entity.AddressEntity;
import com.demo.employee.entity.EmployeeEntity;
import com.demo.employee.repository.AddressRepository;
import com.demo.employee.repository.EmployeeRepository;
import com.demo.employee.util.DaoTransformerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class EmployeeDaoImpl implements EmployeeDao {
    private final AddressRepository addressRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDaoImpl(AddressRepository addressRepository, EmployeeRepository employeeRepository) {
        this.addressRepository = addressRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);

        if (!optionalEmployeeEntity.isPresent()) {
            log.error("Employee not found for id : {}", id);
            throw new EntityNotFoundException("Employee with id: " + id + " doesn't exist.");
        }
        EmployeeEntity employeeEntity = optionalEmployeeEntity.get();

        Optional<AddressEntity> byEmployeeId = addressRepository.findByEmployeeId(employeeEntity.getId());
        return DaoTransformerUtil.getEmployee(employeeEntity, byEmployeeId);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = DaoTransformerUtil.getEmployeeEntity(employee);
        employeeEntity = employeeRepository.save(employeeEntity);

        employee.setId(employeeEntity.getId());

        if (employee.getAddress() != null) {
            log.info("Saving Address for the employee id {}", employee.getId());
            AddressEntity addressEntity = DaoTransformerUtil.getAddressEntity(employee);
            addressRepository.save(addressEntity);
        }
        return employee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        Optional<EmployeeEntity> entity = employeeRepository.findById(id);
        if (!entity.isPresent()) {
            throw new EntityNotFoundException("Employee with " + id + " doesn't exist");
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if (!optionalEmployeeEntity.isPresent()) {
            throw new EntityNotFoundException("Employee with " + id + " doesn't exist");
        }
        EmployeeEntity entity = DaoTransformerUtil.getEmployeeEntity(employee);
        entity.setId(id);
        employeeRepository.save(entity);
        // this is done so as to give back the response with id
        employee.setId(id);
        if (employee.getAddress() != null) {
            log.info("Saving Address for the employee id {}", employee.getId());
            AddressEntity addressEntity = DaoTransformerUtil.getAddressEntity(employee);
            Optional<AddressEntity> byEmployeeId = addressRepository.findByEmployeeId(id);
            if (byEmployeeId.isPresent()) {
                addressEntity.setId(byEmployeeId.get().getId());
            }
            addressRepository.save(addressEntity);
        } else {
            addressRepository.deleteByEmployeeId(id);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee(String filter) {
        List<Employee> employees = new ArrayList<>();
        if (filter.equals("addressOnly")) {
            List<Object[]> entities = employeeRepository.findAllEmployeesWithAddress();
            for (Object[] employee : entities) {
                EmployeeEntity employeeEntity = (EmployeeEntity) employee[0];
                Optional<AddressEntity> entity = Optional.of((AddressEntity) employee[1]);
                employees.add(DaoTransformerUtil.getEmployee(employeeEntity, entity));
            }
        } else {
            List<EmployeeEntity> all = employeeRepository.findAll();
            for (EmployeeEntity employee : all) {
                Optional<AddressEntity> byEmployeeId = addressRepository.findByEmployeeId(employee.getId());
                employees.add(DaoTransformerUtil.getEmployee(employee, byEmployeeId));
            }
        }
        return employees;
    }
}
