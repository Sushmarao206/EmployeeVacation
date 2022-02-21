package com.employee.workdayservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryEmployee extends Employee{
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String empType;

    public SalaryEmployee(String empId) {
        super(empId);
        this.role = ROLE.SALARIED;
        MAX_HOLIDAYS_ALLOWED = 15;
        vacFactor = 0.057f;
    }

}
