package com.demo.employee.repository;

import com.demo.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

//    @Query("SELECT e FROM EmployeeEntity e WHERE Address IS NOT NULL")
//    List<EmployeeEntity> findAllEmployee();

    @Query("SELECT e,a FROM EmployeeEntity e INNER JOIN AddressEntity a ON e.id = a.employeeId")
    List<Object[]> findAllEmployeesWithAddress();

}
