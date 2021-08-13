package com.escuelaeveris.springboot.app.service;

import java.util.List;

import com.escuelaeveris.springboot.app.domain.Laptop;

public interface ILaptopService {
	public Laptop guardar(Laptop l);
	public List<Laptop> listarTodos();
	public Laptop actualizar(Laptop l);
	public void eliminar(Long id);
	public Laptop buscarPorId(Long id);
	public boolean existeId(Long id);
}
