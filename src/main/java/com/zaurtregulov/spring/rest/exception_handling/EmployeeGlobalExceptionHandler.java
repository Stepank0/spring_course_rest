package com.zaurtregulov.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // отмечается класс, предостовляющий функциональность Global Exception Handler-a
public class EmployeeGlobalExceptionHandler {
    //задача метода быть как в АОП промежудком между Клиентом и Контролером и при Exception формировать Json ответ в клиент

    @ExceptionHandler   // отмечается метод , ответственный за обработку исключений
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException exception){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler   // отмечается метод , ответственный за обработку исключений
    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exception){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }






}
