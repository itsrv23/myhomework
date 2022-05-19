package ru.itsrv.myhomework.course2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeIsExistsException extends RuntimeException{
    public EmployeeIsExistsException() {
        super();
    }
}
