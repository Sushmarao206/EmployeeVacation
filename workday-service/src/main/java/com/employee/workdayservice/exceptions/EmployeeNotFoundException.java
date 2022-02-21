package com.employee.workdayservice.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String employee_not_found) {
        super(employee_not_found);
    }
}
