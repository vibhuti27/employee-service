package com.demo.employee.repository;

import com.demo.employee.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {

    Optional<AddressEntity> findByEmployeeId(Integer employeeId);

    void deleteByEmployeeId(Integer employeeId);
}


