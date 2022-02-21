package com.employee.workdayservice.exceptions.advice;

import com.employee.workdayservice.exceptions.EmployeeNotFoundException;
import com.employee.workdayservice.exceptions.ErrorMessage;
import com.employee.workdayservice.exceptions.NotEnoughVacation;
import com.employee.workdayservice.exceptions.NotInRangeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class WorkdayControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage employeeNotFoundException(EmployeeNotFoundException ex, WebRequest request) {

        return new ErrorMessage( HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
    }


    @ExceptionHandler(value = {NotEnoughVacation.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage notEnoughVacation(NotEnoughVacation ex, WebRequest request) {

        return new ErrorMessage( HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
    }


    @ExceptionHandler(value = {NotInRangeException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage notInRangeException(NotInRangeException ex, WebRequest request) {

        return new ErrorMessage( HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
    }


}
