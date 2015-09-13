package com.corppm.technology.pruebas.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orden")
public class Orden {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "fecha", nullable = false)
	private Date fecha;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Cliente cliente;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = OrdenDetalle.class)
	private List<OrdenDetalle> detalles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<OrdenDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<OrdenDetalle> detalles) {
		this.detalles = detalles;
	}

}
