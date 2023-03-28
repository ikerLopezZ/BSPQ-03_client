package com.deustotickets.domain;

public class Gestor extends Usuario{
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gestor(String nombreApellidos, String email, String contrasenya, TipoUsuario tipo, int id) {
		super(nombreApellidos, email, contrasenya, tipo);
		this.id = id;
	}
	
	
	
}
