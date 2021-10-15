package com.test.calculator.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class CalculatorHandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {

		HttpHeaders headers = new HttpHeaders();

		String message = String.format("'%s' should be a valid number.", ex.getValue());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers)
				.body("{\"Error Message\": \"" + message + "\"}");
	}
}