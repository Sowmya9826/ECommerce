package com.scaler.ecommerce.exceptionhandler;

import com.scaler.ecommerce.dtos.ExceptionDto;
import com.scaler.ecommerce.dtos.ProductNotFoundExceptionDto;
import com.scaler.ecommerce.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    private Object exception;

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleAirthmeticException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong");
        exceptionDto.setResolution("Nothing can be done");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto,HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundException.class)
    public ResponseEntity<Void> handleArrayIndexOutOfBoundException(){
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException exception){
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();


        productNotFoundExceptionDto.setMessage("Product" + exception.getId() + "not found");
        ResponseEntity<ProductNotFoundExceptionDto> responseEntity = new ResponseEntity<>(productNotFoundExceptionDto,HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
