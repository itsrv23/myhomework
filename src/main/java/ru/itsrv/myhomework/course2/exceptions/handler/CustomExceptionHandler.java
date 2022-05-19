package ru.itsrv.myhomework.course2.exceptions.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itsrv.myhomework.course2.exceptions.EmployeeNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT) //nice xD // Статус возврата ошибки нужно переопределять в хедере
    @ExceptionHandler(EmployeeNotFoundException.class)
    public void handleCustomIllegalArgumentException(EmployeeNotFoundException exception){
        LOGGER.error(exception.getMessage(), exception);
    }
}
