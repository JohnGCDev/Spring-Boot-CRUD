package com.escuelaeveris.springboot.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escuelaeveris.springboot.app.domain.Laptop;
import com.escuelaeveris.springboot.app.repository.ILaptopRepository;
import com.escuelaeveris.springboot.app.service.ILaptopService;

@Service
public class LaptopServiceImpl implements ILaptopService {

	@Autowired
	private ILaptopRepository repository;
	
	@Override
	public Laptop guardar(Laptop l) {
		return repository.save(l);
	}

	@Override
	public List<Laptop> listarTodos() {
//		List<Laptop> lista = new ArrayList<Laptop>(); // Simulando lista vacía
//		return lista;
		return repository.findAll();
	}

	@Override
	public Laptop actualizar(Laptop l) {
		return repository.save(l);
	}

	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Laptop buscarPorId(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public boolean existeId(Long id) {
		return repository.existsById(id);
	}

//	@Override
//	public List<Laptop> buscarPorMarca(String marca) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
