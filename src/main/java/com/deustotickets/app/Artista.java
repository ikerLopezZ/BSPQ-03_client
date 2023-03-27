package com.deustotickets.app;

public class Artista extends Usuario{

	public TipoGenero genero;
	
	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public Artista(String nombre, String apellidos, String email, String contrasenya, TipoUsuario tipo,
			TipoGenero genero) {
		super(nombre, apellidos, email, contrasenya, tipo);
		this.genero = genero;
	}


}
