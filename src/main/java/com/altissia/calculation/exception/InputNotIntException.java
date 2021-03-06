package com.altissia.calculation.exception;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InputNotIntException extends ResponseEntityExceptionHandler {

	@Override
	public ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		return new ResponseEntity<>("Le tableau des inputs ne doit contenir que des chiffres", new HttpHeaders(),
				HttpStatus.BAD_REQUEST);
	}
}
