package com.app.exception;

import com.app.repointegration.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobaleExceptionHandaller {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Object> exceptionHandller(NoHandlerFoundException ex, WebRequest req) {
        MyerrorDetails err = new MyerrorDetails();
        err.setMessage(ex.getMessage());
        err.setTimeStamp(LocalDateTime.now());
        err.setDiscripation(req.getDescription(false));

        return BaseResponse.errorResponseBuilder("error",err,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exceptionHandller(Exception ex, WebRequest req) {
        MyerrorDetails err = new MyerrorDetails();
        err.setMessage(ex.getMessage());
        err.setTimeStamp(LocalDateTime.now());
        err.setDiscripation(req.getDescription(false));

        return BaseResponse.errorResponseBuilder("error",err,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
