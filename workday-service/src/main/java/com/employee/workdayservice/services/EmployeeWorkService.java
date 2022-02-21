package com.employee.workdayservice.services;

import com.employee.workdayservice.exceptions.EmployeeNotFoundException;
import com.employee.workdayservice.exceptions.NotEnoughVacation;
import com.employee.workdayservice.exceptions.NotInRangeException;
import com.employee.workdayservice.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeWorkService {
    @Autowired
    List<Employee> employees;

    public Employee updateWorkDays(Integer wrkDays, String empId) {
        Optional<Employee> employeeOptional = getEmployeeById(empId);
        Employee employee = employeeOptional.get();
        int currWorkDays = employee.getNoOfWorkingDays() + wrkDays;
        if(currWorkDays > 260 || currWorkDays < 0){
            throw new NotInRangeException("Should be in limits of 0 - 260");
        }else{
            employee.work(wrkDays);
            return employeeOptional.get();
        }
    }

    public Employee updateVacationDays(Float requestedVacationDays, String empId){
        Optional<Employee> employeeOptional = getEmployeeById(empId);
        Employee employee = employeeOptional.get();
        float accumulated = employee.getNoOfVacationDays();
        if(requestedVacationDays < employee.MAX_HOLIDAYS_ALLOWED && requestedVacationDays <= accumulated){
            employee.takeVacation(requestedVacationDays);
            return employee;
        }
        else{
            throw new NotEnoughVacation("Dont have enough vacation + " + employee.getNoOfVacationDays());
        }
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    private Optional<Employee> getEmployeeById(String empId){
        Optional<Employee> employeeOptional = employees.stream().filter(e -> e.getEmployeeId().equals(empId)).findFirst();
        if(employeeOptional.isEmpty()){
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        return employeeOptional;
    }
}
