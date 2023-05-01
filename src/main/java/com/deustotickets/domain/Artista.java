package com.deustotickets.domain;

/**
 * 
 * @author BSPQ-03
 *
 */
public class Artista extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TipoGenero genero;
	public boolean verificada;
	
	public Artista(String nombreApellidos, String email, String contrasenya, TipoUsuario tipo,
			TipoGenero genero, boolean verificada) {
		super(nombreApellidos, email, contrasenya, tipo);
		this.genero = genero;
		this.verificada = verificada;
	}
	
	public Artista(Usuario u, TipoGenero tg, boolean setVerification, boolean verified) {
		super(u.getNombreApellidos(), u.getEmail(), u.getPassword(), u.getTipo());
		
		if(tg != null) {
			this.genero = tg;
		} if(setVerification) {
			this.verificada = verified;
		} else {
			this.verificada = false;
		}
	}
	
	public Artista() {
		super();
	}
	
	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public boolean isVerificada() {
		return verificada;
	}

	public void setVerificada(boolean verificada) {
		this.verificada = verificada;
	}
	
}
