package com.gfg.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LibraryExceptionHandler {

  @ExceptionHandler(value = InvalidBookRequestException.class)
  public ResponseEntity<Object> invalidBookRequestException(InvalidBookRequestException invalidBookRequestException){
    return new ResponseEntity<>("Invalid Book Request", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = InvalidStudentRequestException.class)
  public ResponseEntity<Object> invalidStudentRequestException(InvalidStudentRequestException invalidStudentRequestException){
    return new ResponseEntity<>("Invalid Student Request", HttpStatus.NOT_FOUND);
  }
}
