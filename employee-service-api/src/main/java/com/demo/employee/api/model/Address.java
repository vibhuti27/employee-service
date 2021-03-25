package com.demo.employee.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * Employee's address
 * <p>
 * Employee's address
 */
@Data
public class Address {

    /**
     * line1
     * (Required)
     */
    @JsonProperty("line1")
    @NotBlank(message = "Line1 is mandatory")
    private String line1;
    /**
     * line2
     */
    @JsonProperty("line2")
    private String line2;
    /**
     * city
     * (Required)
     */
    @JsonProperty("city")
    @NotBlank(message = "City is mandatory")
    private String city;
    /**
     * state
     * (Required)
     */
    @JsonProperty("state")
    @NotBlank(message = "State is mandatory")
    private String state;
    /**
     * country
     * (Required)
     */
    @JsonProperty("country")
    @NotBlank(message = "Country is mandatory")
    private String country;
    /**
     * city
     * (Required)
     */
    @JsonProperty("zip_code")
    @NotBlank(message = "Zip Code is mandatory")
    private String zipCode;
}
