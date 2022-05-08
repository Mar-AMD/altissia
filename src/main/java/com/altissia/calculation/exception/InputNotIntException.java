package com.altissia.calculation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Actor Not Found")
public class InputNotIntException extends ResponseEntityExceptionHandler {

}
