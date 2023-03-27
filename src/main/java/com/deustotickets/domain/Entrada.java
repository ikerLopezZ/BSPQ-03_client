package com.deustotickets.domain;

public class Entrada {
	//Atributos:
	private int id;
	private String artista;	//En un futuro hay que meterlo como una clase
	private String precio;
	private String nombre;
	//Pensar si queremos hacer tipos de entrada (VIP, normal...)
	
	//Constructor
	public Entrada(int id, String artista, String precio, String nombre) {
		super();
		this.id = id;
		this.artista = artista;
		this.precio = precio;
		this.nombre = nombre;
	}
	
	//Getters y setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//toString
	@Override
	public String toString() {
		return "Entrada [id=" + id + ", artista=" + artista + ", precio=" + precio + ", nombre=" + nombre + "]";
	}
	
	
	

}
