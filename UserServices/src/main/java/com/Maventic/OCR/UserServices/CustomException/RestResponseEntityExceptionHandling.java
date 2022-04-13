package com.Maventic.OCR.UserServices.CustomException;

import com.Maventic.OCR.UserServices.Beans.ErrorMessage;
import com.Maventic.OCR.UserServices.Beans.HttpResponseMessage;
import com.Maventic.OCR.UserServices.CustomException.Exception.BadRequestException;
import com.Maventic.OCR.UserServices.CustomException.Exception.InternalServerError;
import com.Maventic.OCR.UserServices.CustomException.Exception.UserNotFoundException;
import com.Maventic.OCR.UserServices.CustomException.Exception.WrongValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<HttpResponseMessage> userNotFoundException(UserNotFoundException exception, WebRequest request){
        HttpResponseMessage errorMessage = new HttpResponseMessage(HttpStatus.NOT_FOUND, new ErrorMessage(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(WrongValueException.class)
    public ResponseEntity<HttpResponseMessage> wrongValueException(WrongValueException exception, WebRequest request){
        HttpResponseMessage errorMessage = new HttpResponseMessage(HttpStatus.NOT_ACCEPTABLE,new ErrorMessage(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorMessage);
    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<HttpResponseMessage> internalServerError(InternalServerError exception, WebRequest request){
        HttpResponseMessage errorMessage = new HttpResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR,new ErrorMessage(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<HttpResponseMessage> BadRequestException(BadRequestException exception, WebRequest request){
        HttpResponseMessage errorMessage = new HttpResponseMessage(HttpStatus.BAD_REQUEST,new ErrorMessage(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponseMessage> general(Exception exception, WebRequest request){
        HttpResponseMessage errorMessage = new HttpResponseMessage(HttpStatus.NOT_FOUND,new ErrorMessage(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}