package com.onetradestore.exception;


import com.onetradestore.model.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class TradeAssignmentExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * this method handles all the default exceptions.
     * @param ex
     * @param rq
     * @return ResponseEntity with custom exception and status code
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionModel> handleAllExceptions(Exception ex, WebRequest rq) {
        ExceptionModel ExceptionModel = new ExceptionModel(LocalDate.now(), ex.getMessage());
        return new ResponseEntity<>(ExceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * this method will handle the exceptions thrown for LowerTradeVersionException.
     * @param ex
     * @param rq
     * @return ResponseEntity with custom LowerTradeVersionException and status code
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ExceptionModel> handleLServiceException(Exception ex, WebRequest rq) {
        ExceptionModel ExceptionModel = new ExceptionModel(LocalDate.now(), ex.getMessage());
        return new ResponseEntity<>(ExceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * this method will handle the exceptions thrown for LowerTradeVersionException.
     * @param ex
     * @param rq
     * @return ResponseEntity with custom LowerTradeVersionException and status code
     */
    @ExceptionHandler(BadRequestServiceException.class)
    public ResponseEntity<ExceptionModel> handleBadRequestException(Exception ex, WebRequest rq) {
        ExceptionModel ExceptionModel = new ExceptionModel(LocalDate.now(), ex.getMessage());
        return new ResponseEntity<>(ExceptionModel, HttpStatus.BAD_REQUEST);
    }

    /**
     * this method will handle the exceptions thrown for PastMaturityDateException.
     * @param ex
     * @param rq
     * @return ResponseEntity with custom PastMaturityDateException and status code
     *//*
    @ExceptionHandler(PastMaturityDateException.class)
    public ResponseEntity<ExceptionModel> handlePastMaturityDateException(Exception ex, WebRequest rq) {
        ExceptionModel ExceptionModel = new ExceptionModel(LocalDate.now(), ex.getMessage());
        return new ResponseEntity<>(ExceptionModel, HttpStatus.BAD_REQUEST);
    }
    *//**
     * this method will handle the exceptions thrown for TradeStoreEmptyException.
     * @param ex
     * @param rq
     * @return ResponseEntity with custom TradeStoreEmptyException and status code
     *//*
    @ExceptionHandler(TradeStoreEmptyException.class)
    public ResponseEntity<ExceptionModel> handleTradeStoreEmptyException(Exception ex, WebRequest rq) {
        ExceptionModel ExceptionModel = new ExceptionModel(LocalDate.now(), ex.getMessage());
        return new ResponseEntity<>(ExceptionModel, HttpStatus.NOT_FOUND);
    }*/

}
