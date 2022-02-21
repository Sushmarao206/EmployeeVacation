package com.employee.workdayservice.exceptions;

public class NotEnoughVacation extends RuntimeException{
    public NotEnoughVacation(String message) {
        super(message);
    }
}
