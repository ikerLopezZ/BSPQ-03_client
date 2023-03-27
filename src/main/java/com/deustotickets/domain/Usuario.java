package com.deustotickets.domain;

public class Usuario {
	// Atributos:
	private String nombreApellidos;
	private String email;
	private String password;
	private TipoUsuario tipo;
	
	//Constructor:
	public Usuario(String nombre, String apellidos, String email, String password, TipoUsuario tipo) {
		super();
		this.email = email;
		this.password = password;
		this.tipo = tipo;
	}
	
	public Usuario() {
		super();
	}


	//Getters y Setters:
	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public void setNombreApellidos(String nombre) {
		this.nombreApellidos = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Usuario [nombre y apellidos=" + nombreApellidos + ", email=" + email + ", password="
				+ password + ", tipo=" + tipo + "]";
	}
	
}
