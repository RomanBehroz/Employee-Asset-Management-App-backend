package com.romanyou.Employee.Asset.Management.exception;

import com.romanyou.Employee.Asset.Management.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Author Roman
 * Handles http request status and message delivery
 * Error Handling
 */
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<ErrorMessage> emptyFieldException(EmptyFieldException emptyFieldException, WebRequest webRequest){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE, emptyFieldException.getMessage());

        return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(errorMessage);
    }


    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorMessage> alreadyExistException(AlreadyExistException alreadyExistException, WebRequest webRequest){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE, alreadyExistException.getMessage());

        return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(errorMessage);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> notFoundException(NotFoundException notFoundException, WebRequest webRequest){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, notFoundException.getMessage());

        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorMessage);
    }



}
