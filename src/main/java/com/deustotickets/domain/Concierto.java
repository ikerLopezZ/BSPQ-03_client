package com.deustotickets.domain;

public class Concierto {
	//Atributos:
	private int id;
	private Artista artista;
	private String fecha;
	private String lugar;
	private int aforo;
	
	//Constructor
	public Concierto(Artista artista, String fecha, String lugar, int aforo) {
		super();
		this.artista = artista;
		this.fecha = fecha;
		this.lugar = lugar;
		this.aforo = aforo;
	}

	//Getters y setters
	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	//toString
	@Override
	public String toString() {
		return "Concierto [artista=" + artista.toString() + ", fecha=" + fecha + ", lugar=" + lugar + ", aforo=" + aforo + "]";
	}
}
