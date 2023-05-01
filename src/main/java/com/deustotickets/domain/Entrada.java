package com.deustotickets.domain;

/**
 * 
 * @author BSPQ-03
 *
 */
public class Entrada {
	private String id;
	private Concierto concierto;
	private double precio;
	private String nombre;
	// Pensar si queremos hacer tipos de entrada (VIP, normal, ...)
	
	public Entrada(String id, Concierto concierto, double precio, String nombre) {
		super();
		this.id = id;
		this.concierto = concierto;
		this.precio = precio;
		this.nombre = nombre;
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
