package com.deustotickets.domain;

/**
 * 
 * @author BSPQ-03
 *
 */
public class Usuario {
	private String nombreApellidos;
	private String email;
	private String password;
	private TipoUsuario tipo;
	
	public Usuario(String nombreApellidos, String email, String password, TipoUsuario tipo) {
		super();
		this.nombreApellidos = nombreApellidos;
		this.email = email;
		this.password = password;
		this.tipo = tipo;
	}
	
	public Usuario() {
		super();
	}

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

	@Override
	public String toString() {
		return "Usuario [nombre y apellidos=" + nombreApellidos + ", email=" + email + ", password="
				+ password + ", tipo=" + tipo + "]";
	}
}