package com.escuelaeveris.springboot.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.escuelaeveris.springboot.app.errors.RecursoException;
import com.escuelaeveris.springboot.app.util.CustomHttpErrorResponse;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(RecursoException.class)
	public ResponseEntity<CustomHttpErrorResponse> handleException(RecursoException e) {
		return ResponseEntity.status(e.getHttpStatus())
				.body(new CustomHttpErrorResponse(e.getHttpStatus(), e.getMessage()));
	}
}
