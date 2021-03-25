package com.demo.employee.api.controller;

import com.demo.employee.api.model.Employee;
import com.demo.employee.api.model.GetAllEmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Interface for employee resource operations.
 */
@RequestMapping("/rest/api/v1/employees")
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<Employee> employeeGetById(@PathVariable("id") @Valid @NotNull String id);

    /**
     * Creates the {@link Employee} resource.
     *
     * @param employee {@link Employee}.
     * @return {@link Employee} resource.
     */
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee);

    /**
     * Deletes the {@link Employee} by id.
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteEmployee(@PathVariable("id") String id);

    /**
     * Updates the {@link Employee} by id.
     *
     * @param id
     * @param employee
     * @return {@link Employee} resource.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee);

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<GetAllEmployeeResponse> getAllEmployees(@RequestParam(value = "sort", defaultValue = "ASC") String sort, @RequestParam(value = "filter", defaultValue = "all") String filter);


}
