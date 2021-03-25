package com.demo.employee.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


/**
 * Employee
 * <p>
 * Employee resource object
 */
@Data
public class Employee {

    /**
     * employee id
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * first name
     * (Required)
     */
    @JsonProperty("first_name")
    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    /**
     * last name
     * (Required)
     */
    @JsonProperty("last_name")
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;
    /**
     * Employee's date of birth
     * <p>
     * Employee's date of birth
     */
    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;
    /**
     * Employee's address
     * <p>
     * Employee's address
     */
    @JsonProperty("address")
    @Valid
    private Address address;
}
