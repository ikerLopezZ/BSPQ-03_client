package com.deustotickets.domain;

/**
 * 
 * @author BSPQ-03
 *
 */
public class Entrada {
	private int id;
	private Artista artista;
	private double precio;
	private String nombre;
	// Pensar si queremos hacer tipos de entrada (VIP, normal, ...)
	
	public Entrada(int id, Artista artista, double precio, String nombre) {
		super();
		this.id = id;
		this.artista = artista;
		this.precio = precio;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
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
		return "Entrada [id=" + id + ", artista=" + artista + ", precio=" + precio + ", nombre=" + nombre + "]";
	}
}