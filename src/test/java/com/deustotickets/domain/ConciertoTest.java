package com.deustotickets.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConciertoTest {
	
	Concierto c;

	@Before
	public void setUp() throws Exception {
		c = new Concierto("0", new Artista(), "01/01/2000", "test", 0);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetId() {
		assertEquals(c.getId().getClass(), String.class);
	}
	
	@Test
	public void testGetArtista() {
		assertEquals(c.getArtista().getClass(), Artista.class);
	}
	
	@Test
	public void testSetArtista() {
		c.setArtista(new Artista());
	}
	
	@Test
	public void testGetFecha() {
		assertEquals(c.getFecha().getClass(), String.class);
	}
	
	@Test
	public void testSetFecha() {
		c.setFecha("01/01/2000");
	}
	
	@Test
	public void testGetLugar() {
		assertEquals(c.getLugar().getClass(), String.class);
	}
	
	@Test
	public void testSetLugar() {
		c.setLugar("test");
	}
	
	@Test
	public void testGetAforo() {
		assertEquals(c.getAforo(), 0);
	}
	
	@Test
	public void testSetAforo() {
		c.setAforo(0);
	}
	
	@Test
	public void testToString() {
		assertEquals(c.toString(), "Concierto : 0. ARTISTA: Usuario [nombre y apellidos=null, email=null, password=null, tipo=null], FECHA: 01/01/2000, LUGAR: test, entradasDisponibles: 0.");
	}
		
}
