package com.demo.employee.util;

import com.demo.employee.api.model.Address;
import com.demo.employee.api.model.Employee;
import com.demo.employee.entity.AddressEntity;
import com.demo.employee.entity.EmployeeEntity;

import java.util.Optional;

/**
 * Transformer class to Transform {@link Employee} to {@link EmployeeEntity} and vice versa.
 */
public class DaoTransformerUtil {

    public static EmployeeEntity getEmployeeEntity(Employee employee) {
        return EmployeeEntity.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .dateOfBirth(employee.getDateOfBirth()).build();
    }

    public static AddressEntity getAddressEntity(Employee employee) {
        return AddressEntity.builder()
                .employeeId(employee.getId())
                .line1(employee.getAddress().getLine1())
                .line2(employee.getAddress().getLine2())
                .city(employee.getAddress().getCity())
                .state(employee.getAddress().getState())
                .country(employee.getAddress().getCountry())
                .zipCode(employee.getAddress().getZipCode()).build();
    }

    public static Employee getEmployee(EmployeeEntity employeeEntity, Optional<AddressEntity> addressEntityOptional) {
        Employee employee = new Employee();
        employee.setId(employeeEntity.getId());
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setDateOfBirth(employeeEntity.getDateOfBirth());
        if (addressEntityOptional.isPresent()) {
            Address address = new Address();
            AddressEntity addressEntity = addressEntityOptional.get();
            address.setLine1(addressEntity.getLine1());
            address.setLine2(addressEntity.getLine2());
            address.setCity(addressEntity.getCity());
            address.setState(addressEntity.getState());
            address.setCountry(addressEntity.getCountry());
            address.setZipCode(addressEntity.getZipCode());
            employee.setAddress(address);
        }
        return employee;
    }
}
