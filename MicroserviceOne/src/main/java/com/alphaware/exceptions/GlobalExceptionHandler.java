package com.alphaware.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RecordAlreadyExistException.class)
	public ResponseEntity<APIErrorResponse> handleRecordAlreadyExistException(RecordAlreadyExistException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		APIErrorResponse errorResponse = new APIErrorResponse();
		errorResponse.setMessage(e.getMessage());
		errorResponse.setTimeStamp(LocalDateTime.now());
		errorResponse.setStatusCode(status.value());

		return new ResponseEntity<>(errorResponse, status);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<APIErrorResponse> handleRecordNotFoundException(RecordNotFoundException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		APIErrorResponse errorResponse = new APIErrorResponse();
		errorResponse.setMessage(e.getMessage());
		errorResponse.setTimeStamp(LocalDateTime.now());
		errorResponse.setStatusCode(status.value());

		return new ResponseEntity<>(errorResponse, status);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<APIErrorResponse> handleException(Exception e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		APIErrorResponse errorResponse = new APIErrorResponse();
		errorResponse.setMessage(e.getMessage());
		errorResponse.setTimeStamp(LocalDateTime.now());
		errorResponse.setStatusCode(status.value());

		return new ResponseEntity<>(errorResponse, status);
	}
}
