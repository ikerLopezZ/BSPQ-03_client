package com.deustotickets.domain;

import java.io.Serializable;

/**
 * 
 * @author BSPQ-03
 *
 */
public class Entrada implements Serializable {
	private String id;
	private Concierto concierto;
	private double precio;
	private String nombre;
	
	
	public Entrada(String id, Concierto concierto, double precio, String nombre) {
		super();
		this.id = id;
		this.concierto = concierto;
		if(this.concierto.getEntradasDisponibles() > 0) {
			this.concierto.comprarEntrada();
		}
		this.precio = precio;
		this.nombre = nombre;
	}
	
	public Entrada() {
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public Concierto getConcierto() {
		return concierto;
	}
	public void setConcierto(Concierto concierto) {
		this.concierto = concierto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", concierto=" + concierto + ", precio=" + precio + ", nombre=" + nombre + "]";
	}
	
}
