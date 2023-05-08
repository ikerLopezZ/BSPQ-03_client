package com.deustotickets.domain;

/**
 * 
 * @author BSPQ-03
 *
 */
public class Concierto {
	private String id;
	private Artista artista;
	private String fecha;
	private String lugar;
	private int aforo;
	private int entradasDisponibles;
	
	public Concierto(String id, Artista artista, String fecha, String lugar, int aforo) {
		super();
		this.id = id;
		this.artista = artista;
		this.fecha = fecha;
		this.lugar = lugar;
		this.aforo = aforo;
		this.entradasDisponibles = aforo;
	}
	
	public Concierto() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
	
	public int getEntradasDisponibles() {
		return entradasDisponibles;
	}

	public void setEntradasDisponibles(int entradasDisponibles) {
		this.entradasDisponibles = entradasDisponibles;
	}

	public void comprarEntrada() {
		this.entradasDisponibles--;
	}
	
	public void devolverEntrada() {
		this.entradasDisponibles++;
	}
	
	@Override
	public String toString() {
		return "Concierto : " + id + ". ARTISTA: " + artista + ", FECHA: " + fecha + ", LUGAR: " + lugar + ", entradasDisponibles: " + entradasDisponibles + ".";
	}
	
}
