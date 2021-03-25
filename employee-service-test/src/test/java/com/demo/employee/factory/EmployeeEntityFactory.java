package com.demo.employee.factory;

import com.demo.employee.entity.EmployeeEntity;

import java.time.LocalDate;

public class EmployeeEntityFactory {

    public static EmployeeEntity getDummyEmployee() {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(1);
        entity.setFirstName("FirstName");
        entity.setLastName("LastName");
        entity.setDateOfBirth(LocalDate.of(1994, 9, 25));
        return entity;
    }
}
