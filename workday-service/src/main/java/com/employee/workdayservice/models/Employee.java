package com.employee.workdayservice.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
public abstract class Employee implements Serializable {

    public Integer MAX_HOLIDAYS_ALLOWED;

    @Value("${some.key:0}")
    @Min(0)
    @Max(260)
    int noOfWorkingDays;

    @Value("${some.key:0}")
    float noOfVacationDays;

    float vacFactor;

    ROLE role;

    String employeeId;

    public Employee(String employeeId) {
        this.employeeId = employeeId;
    }

    public void work(@Min(0) @Max(260) Integer noOfDays){
        noOfWorkingDays = noOfWorkingDays + noOfDays;
        float vacDays = noOfVacationDays + noOfDays * vacFactor;
        noOfVacationDays = noOfVacationDays < 1 ? vacDays : Math.round(vacDays);
    }
    public void takeVacation(Float vacationDays){
        noOfVacationDays = noOfVacationDays - vacationDays;
    }

}
enum ROLE{
    HOURLY,
    SALARIED,
    MANAGER
}