# Employee Service

## Application Overview
Employee Service is a spring boot rest application which would provide the CRUD operations for `Employee` resource.

There are three modules in this application
- employee-service-api - This module contains the interface.
	- `v1/schema/employee.json` defines the employee resource.
	- `EmployeeResource.java` is the interface for CRUD operations on `Employee` resource.
		- GET `/rest/api/v1/employees/{id}` endpoint is defined to fetch the resource.
- employee-service-impl - This module contains the implementation for the rest endpoints.
	- `EmployeeResourceImpl.java` implements the `EmployeeResource` interface.
- employee-service-test - This module would have the functional tests.

## How to run the application
- Please have Maven version `3.3.3` & Java 8 on your system.
- Use command `mvn clean install` to build the project.
- Use command `mvn spring-boot:run` from `employeeservImplementation` folder to run the project.
- Use postman or curl to access `http://localhost:8080/rest/api/v1/employees/1` GET endpoint. It will return an Employee resource.