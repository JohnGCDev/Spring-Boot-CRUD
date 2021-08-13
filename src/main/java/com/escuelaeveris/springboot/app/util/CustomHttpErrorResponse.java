package com.escuelaeveris.springboot.app.util;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomHttpErrorResponse {

	private HttpStatus estado;
	private String error;

}
