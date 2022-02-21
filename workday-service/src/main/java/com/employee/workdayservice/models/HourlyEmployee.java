package com.employee.workdayservice.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HourlyEmployee extends Employee{

    public HourlyEmployee(String empId) {
        super(empId);
        this.role = ROLE.HOURLY;
        MAX_HOLIDAYS_ALLOWED = 10;
        vacFactor = 0.038f;
    }

}
