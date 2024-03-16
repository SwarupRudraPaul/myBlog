package com.myBlog.myBlog.exception;

import com.myBlog.myBlog.payLoad.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerException(
            ResourceNotFoundException e,
            WebRequest wr
    ){
        ErrorDetails ed = new ErrorDetails(e.getMessage(),new Date(),wr.getDescription(true));
        return new ResponseEntity<>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
    };
}
