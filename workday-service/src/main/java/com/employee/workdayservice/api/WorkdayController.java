package com.employee.workdayservice.api;

import com.employee.workdayservice.models.Employee;
import com.employee.workdayservice.models.HourlyEmployee;
import com.employee.workdayservice.models.SalaryEmployee;
import com.employee.workdayservice.services.EmployeeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
public class WorkdayController {

    @Autowired
    EmployeeWorkService employeeWorkService;

    @GetMapping("/v1/api/employee/employees")
    public ResponseEntity<?> employees(){
        return ResponseEntity.ok(employeeWorkService.getAllEmployees());
    }

    @GetMapping("/v1/api/employee/workday")
    public ResponseEntity<?> updateWorkingDays(@Valid @RequestParam("days")
                                            @Min(0) @Max(260) Integer wrkDays,
                                               @RequestParam("empId") String empId){
        return ResponseEntity.ok(employeeWorkService.updateWorkDays(wrkDays, empId));
    }

    @GetMapping("/v1/api/employee/vacation")
    public ResponseEntity<?> updateVacationDays(@Valid @RequestParam("days")
                                               @Min(0) @Max(260) Float requestedVacationDays,
                                               @RequestParam("empId") String empId){
        return ResponseEntity.ok(employeeWorkService.updateVacationDays(requestedVacationDays, empId));
    }

}
