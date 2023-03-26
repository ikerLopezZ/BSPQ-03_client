package com.deustotickets.app;

public class Usuario {
	// Atributos:
	private String nombre;
	private String apellidos;
	private String email;
	private String contrasenya;
	private TipoUsuario tipo;
	
	//Constructor:
	public Usuario(String nombre, String apellidos, String email, String contrasenya, TipoUsuario tipo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasenya = contrasenya;
		this.tipo = tipo;
	}

	//Getters y Setters:
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	//toString:
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", contrasenya="
				+ contrasenya + ", tipo=" + tipo + "]";
	}
	
}
