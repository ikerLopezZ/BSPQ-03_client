package com.deustotickets.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EntradaTest {
	
	Entrada e;

	@Before
	public void setUp() throws Exception {
		e = new Entrada("0", new Concierto(), 0.0, "test");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testEntrada() {
		Entrada e = new Entrada("0", new Concierto(), 0.0, "test");
	}
	
	@Test
	public void testGetId() {
		assertEquals(e.getId().getClass(), String.class);
	}
	
	@Test
	public void testSetId() {
		e.setId("0");
	}
	
	@Test
	public void testGetConcierto() {
		assertEquals(e.getConcierto().getClass(), Concierto.class);
	}
	
	@Test
	public void testSetConcierto() {
		e.setConcierto(new Concierto());
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(e.getPrecio(), 0, 0);
	}
	
	@Test
	public void testSetPrecio() {
		e.setPrecio(0.0);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals(e.getNombre().getClass(), String.class);
	}
	
	@Test
	public void testSetNombre() {
		e.setNombre("test");
	}
	
	@Test
	public void testToString() {
		assertEquals(e.toString(), "Entrada [id=0, concierto=Concierto : null. ARTISTA: null, FECHA: null, LUGAR: null, entradasDisponibles: 0., precio=0.0, nombre=test]");
	}
		
}
