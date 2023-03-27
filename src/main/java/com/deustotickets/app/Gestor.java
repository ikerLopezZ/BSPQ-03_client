package com.deustotickets.app;

public class Gestor extends Usuario{
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gestor(String nombre, String apellidos, String email, String contrasenya, TipoUsuario tipo, int id) {
		super(nombre, apellidos, email, contrasenya, tipo);
		this.id = id;
	}
	
	
	
}
