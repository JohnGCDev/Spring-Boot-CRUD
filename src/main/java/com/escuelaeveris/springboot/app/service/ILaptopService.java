package com.escuelaeveris.springboot.app.service;

import java.util.List;


//import org.springframework.data.jpa.repository.Query;

import com.escuelaeveris.springboot.app.domain.Laptop;

public interface ILaptopService {
	public Laptop guardar(Laptop l);
	public List<Laptop> listarTodos();
	public Laptop actualizar(Laptop l);
	public void eliminar(Long id);
	public Laptop buscarPorId(Long id);
	public boolean existeId(Long id);
//	@Query("SELECT l FROM Laptop l WHERE l.marca = ?1")
//	public List<Laptop> buscarPorMarca(String marca);
}
