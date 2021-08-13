package com.escuelaeveris.springboot.app.util;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class CustomHttpResponse {

	private HttpStatus estado;
	private String mensaje;
	private Timestamp timeStamp;

	public CustomHttpResponse(HttpStatus estado, String mensaje) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
		Date date = new Date();
		this.timeStamp = new Timestamp(date.getTime());
	}

}
