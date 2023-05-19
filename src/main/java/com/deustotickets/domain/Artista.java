package com.deustotickets.domain;

/**
 * Class that represents an artist.
 * 
 * @author BSPQ-03
 */
public class Artista extends Usuario {
	private static final long serialVersionUID = 1L;
	public TipoGenero genero;
	public boolean verificada;
	
	/**
	 * Class constructor.
	 */
	public Artista() {
		super();
	}
	
	/**
	 * Class constructor specifying first and last name, e-mail, password, type of user, musical genre and verification status of the artist.
	 * 
	 * @param nombreApellidos first and last name of the artist
	 * @param email e-mail of the artist
	 * @param contrasenya password of the artist
	 * @param tipo type of user of the artist
	 * @param genero musical genre of the artist
	 * @param verificada verification status of the artist
	 */
	public Artista(String nombreApellidos, String email, String contrasenya, TipoUsuario tipo,
			TipoGenero genero, boolean verificada) {
		super(nombreApellidos, email, contrasenya, tipo);
		this.genero = genero;
		this.verificada = verificada;
	}
	
	/**
	 * Class constructor specifying user, musical genre and verification status of the artist.
	 * Transforms a user into an artist by adding its corresponding attributes.
	 * 
	 * @param u user to transform into artist
	 * @param tg musical genre of the artist
	 * @param setVerification indicates if the artist is going to be verified or not
	 * @param verified indicates whether or not the artist is verified
	 */
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
	
	/**
	 * Returns the gender of the artist.
	 * 
	 * @return A TipoGenero representing the artist's gender
	 * @see TipoGenero 
	 */
	public TipoGenero getGenero() {
		return genero;
	}
	
	/**
	 * Registers the gender of the artist.
	 * 
	 * @param genero the TipoGenero to set
	 * @see TipoGenero
	 */
	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}
	
	/**
	 * Returns the verification status of the artist.
	 * 
	 * @return A boolean representing the artist's verification status
	 */
	public boolean isVerificada() {
		return verificada;
	}
	
	/**
	 * Registers the verification status of the artist.
	 * 
	 * @param verificada the boolean to set
	 */
	public void setVerificada(boolean verificada) {
		this.verificada = verificada;
	}
	
}
