package com.escuelaeveris.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escuelaeveris.springboot.app.domain.Laptop;

public interface ILaptopRepository extends JpaRepository<Laptop, Long>{

}
