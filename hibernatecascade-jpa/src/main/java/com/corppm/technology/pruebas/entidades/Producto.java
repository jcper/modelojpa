package com.corppm.technology.pruebas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "sku", nullable = false)
	private String SKU;
	@Column(name = "precio", nullable = false)
	private Double precio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
