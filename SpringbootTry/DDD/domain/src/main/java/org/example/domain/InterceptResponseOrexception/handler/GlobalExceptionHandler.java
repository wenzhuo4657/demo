package org.example.domain.InterceptResponseOrexception.handler;


import org.example.domain.InterceptResponseOrexception.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public ErrorInfo handleException(ServiceException e, HttpServletRequest req, HttpServletResponse resp)
    {
        return ErrorInfo.Builder.builder().code(e.getCode()).info(e.getMessage()).build();
    }
}
