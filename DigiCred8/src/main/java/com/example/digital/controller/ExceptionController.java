package com.example.digital.controller;

import com.example.digital.common.Constants;
import com.example.digital.common.ErrorMessages;
import com.example.digital.common.ErrorResponse;
import com.example.digital.common.RestResponse;
import com.example.digital.exception.DigiSignException;
import com.example.digital.exception.ErrorDetails;
import com.example.digital.exception.FileStorageException;
import com.example.digital.exception.MyFileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(FileStorageException.class)
    public final ResponseEntity<ErrorDetails> handlingFileStorageException(HttpServletRequest request, FileStorageException ex){
        UUID id = UUID.randomUUID();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
        ErrorDetails response = new ErrorDetails(id,timeStamp,request.getRequestURL().toString(),request.getMethod(),ex.getMessage());

        return new ResponseEntity<ErrorDetails>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DigiSignException.class)
    @ResponseBody
    public ResponseEntity exceptionHandler(DigiSignException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getReasonPhrase(),
                e.getCode());
        LOGGER.error("Exception message{}",e);
        return populateRestEntity(e.getReasonPhrase(), errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private ResponseEntity populateRestEntity(String errorMsg, ErrorResponse errorResponse, HttpStatus status) {
        RestResponse restResponse  = new RestResponse();
        LOGGER.error(errorMsg);
        restResponse.add(Constants.STATUS, Constants.ERROR);
        restResponse.add(Constants.ERROR, errorResponse);
        return ResponseEntity.status(status).body(restResponse);
    }



    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handlingAllDigiSignException(HttpServletRequest request,Exception ex){
        UUID id = UUID.randomUUID();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
        ErrorDetails response = new ErrorDetails(id,timeStamp,request.getRequestURL().toString(),request.getMethod(),ex.getMessage());
        LOGGER.error("Exception message{}",ex);
        return new ResponseEntity<ErrorDetails>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
