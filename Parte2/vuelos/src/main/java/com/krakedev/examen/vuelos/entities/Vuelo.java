package com.krakedev.examen.vuelos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vuelos")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 10, nullable = false, unique = true)
	private String codigo;

	@Column(name = "precio_boleto", nullable = false)
	private double precioBoleto;

	@Column(name = "asientos_disponibles", nullable = false)
	private int asientosDisponibles;

	public Vuelo() {
		super();
	}

	public Vuelo(Integer id, String codigo, double precioBoleto, int asientosDisponibles) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.precioBoleto = precioBoleto;
		this.asientosDisponibles = asientosDisponibles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPrecioBoleto() {
		return precioBoleto;
	}

	public void setPrecioBoleto(double precioBoleto) {
		this.precioBoleto = precioBoleto;
	}

	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(int asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	@Override
	public String toString() {
		return "Vuelo [id=" + id + ", codigo=" + codigo + ", precioBoleto=" + precioBoleto + ", asientosDisponibles="
				+ asientosDisponibles + "]";
	}

}
