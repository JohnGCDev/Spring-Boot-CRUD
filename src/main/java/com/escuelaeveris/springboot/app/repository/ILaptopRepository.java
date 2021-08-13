package com.escuelaeveris.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.escuelaeveris.springboot.app.domain.Laptop;

public interface ILaptopRepository extends JpaRepository<Laptop, Long>{
	@Query("SELECT l FROM Laptop l WHERE l.marca = ?1")
	public List<Laptop> buscarPorMarca(String marca);
}
