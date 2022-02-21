package com.employee.workdayservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
public class ManagerEmployee extends SalaryEmployee{

    public ManagerEmployee(String empId) {
        super(empId);
        role = ROLE.MANAGER;
        MAX_HOLIDAYS_ALLOWED = 30;
        vacFactor = 0.115f;
    }

}
