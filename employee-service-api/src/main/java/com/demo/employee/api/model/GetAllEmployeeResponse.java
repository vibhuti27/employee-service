package com.demo.employee.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"totalRecords", "employees"})
public class GetAllEmployeeResponse {

    @JsonProperty("employees")
    private List<Employee> employees;

    @JsonProperty("totalRecords")
    int total;

}
