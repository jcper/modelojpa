package com.corppm.technology.pruebas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "dna", nullable = false)
	private String DNA;
	@Column(name = "nombre_completo", nullable = false)
	private String nombreCompleto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDNA() {
		return DNA;
	}

	public void setDNA(String dNA) {
		DNA = dNA;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

}
