package com.employee.workdayservice.exceptions;

public class NotInRangeException extends RuntimeException{
    public NotInRangeException(String message) {
        super(message);
    }
}
