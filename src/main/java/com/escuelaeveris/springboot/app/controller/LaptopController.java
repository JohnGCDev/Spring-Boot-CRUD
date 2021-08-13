package com.escuelaeveris.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuelaeveris.springboot.app.domain.Laptop;
import com.escuelaeveris.springboot.app.errors.RecursoException;
import com.escuelaeveris.springboot.app.service.ILaptopService;
import com.escuelaeveris.springboot.app.util.CustomHttpResponse;

//import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/laptops")
//@Log4j2
public class LaptopController {
	
	@Autowired
	private ILaptopService laptopService;
	
	// --- CREAR ----
	@PostMapping("/crear")
	public ResponseEntity<Object> crearLaptop(@RequestBody Laptop l){
		// Validación de no nulidad
		if(l == null) {
			throw new RecursoException(HttpStatus.BAD_REQUEST, "Es necesario especificar información de la laptop a guardar.");
		}
		// Validación de no existencia
		if(l.getId() != null) {
			if(laptopService.buscarPorId(l.getId()) instanceof Laptop) {
				throw new RecursoException(HttpStatus.BAD_REQUEST, "La laptop con el id '" + l.getId() + "' ya existe.");
			}
		}
		// Validaciones de data
		if(l.getMarca() == null || l.getMarca().isEmpty()) {
			throw new RecursoException(HttpStatus.BAD_REQUEST, "Es necesario especificar la marca de la laptop obligatoriamente.");			
		}
		if(l.getPrecio() == null || l.getPrecio() <= 100.0) {
			throw new RecursoException(HttpStatus.BAD_REQUEST, "El precio de la laptop debe ser mayor a S/100.0");						
		}
		
		Laptop laptop = laptopService.guardar(l);
		// Enviando respuesta exitosa al cliente
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new CustomHttpResponse(HttpStatus.CREATED, "La laptop con id '"+ laptop.getId() +"' ha sido creada correctamente."));
		
	}
	
	// --- LISTAR ----
	@GetMapping("/listar")
	public ResponseEntity<Object> listarLaptops(){
		List<Laptop> lista = laptopService.listarTodos();
		
		if(lista == null || lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new CustomHttpResponse(HttpStatus.OK, "Lo sentimos. No se encontraron resultados."));
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	// --- ACTUALIZAR ----
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Object> actualizarLaptop(@RequestBody Laptop l, @PathVariable Long id){
		// Validación de no nulidad
		if(l == null) {
			throw new RecursoException(HttpStatus.BAD_REQUEST, "Es necesario especificar información de la laptop a actualizar.");
		}
		// Validaciones de data
		if(l.getMarca() == null || l.getMarca().isEmpty()) {
			throw new RecursoException(HttpStatus.BAD_REQUEST, "Es necesario especificar la marca de la laptop obligatoriamente.");			
		}
		if(l.getPrecio() == null || l.getPrecio() <= 100.0) {
			throw new RecursoException(HttpStatus.BAD_REQUEST, "El precio de la laptop debe ser mayor a S/100.0");						
		}
		// Proceder a actualizar/guardar
		if(laptopService.existeId(id)) { // Verificar si existe la laptop en bd		
			Laptop laptop = laptopService.actualizar(l);
			
			return ResponseEntity.status(HttpStatus.OK)
					.body(new CustomHttpResponse(HttpStatus.OK, "La laptop con id '"+ laptop.getId() +"' ha sido actualizada correctamente."));
			
		}else { // De no existir crear registro
			Laptop laptop = laptopService.guardar(l);
			// Enviando respuesta exitosa al cliente
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new CustomHttpResponse(HttpStatus.CREATED, "La laptop con id '"+ laptop.getId() +"' ha sido creada correctamente ya que antes no existía."));
		}
	}
	
	// --- ELIMINAR ---
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminarLaptop(@PathVariable Long id) {
		if(laptopService.existeId(id)) { // Eliminar objeto Laptop solo si existe en bd			
			laptopService.eliminar(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new CustomHttpResponse(HttpStatus.OK, "La laptop con id '" + id + "' se ha eliminado correctamente."));
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(new CustomHttpResponse(HttpStatus.OK, "Lo sentimos. La laptop a eliminar con id '" + id + "' no existe."));
	}
	
	// --- BUSCAR POR ID ---
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Object> buscarLaptopPorId(@PathVariable Long id){
		if(laptopService.existeId(id)) { // Retornar objeto Laptop solo si existe en bd			
			return ResponseEntity.status(HttpStatus.OK).body(laptopService.buscarPorId(id));
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(new CustomHttpResponse(HttpStatus.OK, "Lo sentimos. La laptop con id '" + id + "' no existe."));
	}
}
