package com.escuelaeveris.springboot.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "laptops")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_laptop")
	private Long id;
	
	@Column(name = "marca_laptop", length = 15, nullable = false)
	@Size(max = 15, min = 1)
	@NotNull
	private String marca;
	
	@Column(name = "precio_laptop", nullable = false, precision = 3, scale = 3)
	@NotNull
	private Double precio;
	
	@Column(name = "color_laptop", length = 10)
	@Size(max = 10, min = 2)
	private String color;
	
}
