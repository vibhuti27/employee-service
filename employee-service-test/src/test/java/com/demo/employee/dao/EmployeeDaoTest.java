package com.demo.employee.dao;

import com.demo.employee.api.model.Employee;
import com.demo.employee.dao.impl.EmployeeDaoImpl;
import com.demo.employee.entity.EmployeeEntity;
import com.demo.employee.factory.EmployeeEntityFactory;
import com.demo.employee.repository.AddressRepository;
import com.demo.employee.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class EmployeeDaoTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private EmployeeDaoImpl employeeDao;

    @Test
    public void testGetEmployeeByIdSuccess() {
        EmployeeEntity dummyEmployee = EmployeeEntityFactory.getDummyEmployee();
        // if in my actual flow, employeeRepository.findById(1) is called with id:1 then this will return my dummyEmployee
        when(employeeRepository.findById(1)).thenReturn(Optional.of(dummyEmployee));

        Employee actual = employeeDao.getEmployeeById(1);

        Assert.assertEquals(dummyEmployee.getId(), actual.getId());
        Assert.assertEquals(dummyEmployee.getFirstName(), actual.getFirstName());
        Assert.assertEquals(dummyEmployee.getLastName(), actual.getLastName());
        Assert.assertEquals(dummyEmployee.getDateOfBirth(), actual.getDateOfBirth());
    }

    @Test
    public void testGetEmployeeByIdNotFound() {
        when(employeeRepository.findById(1)).thenReturn(Optional.empty());

        EntityNotFoundException entityNotFoundException = catchThrowableOfType(() -> employeeDao.getEmployeeById(1), EntityNotFoundException.class);

        Assert.assertEquals("Employee with id: 1 doesn't exist.", entityNotFoundException.getMessage());
    }


}
