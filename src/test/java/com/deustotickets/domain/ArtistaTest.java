package com.deustotickets.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArtistaTest {
	
	Artista a;

	@Before
	public void setUp() throws Exception {
		a = new Artista("test", "test@example.com", "password", TipoUsuario.ARTISTA, TipoGenero.BLUES, true);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testArtista() {
		Artista a = new Artista(new Usuario(), TipoGenero.BLUES, true, true);
		Artista a1 = new Artista(new Usuario(), null, true, false);
		Artista a2 = new Artista(new Usuario(), null, false, true);
	}
	
	@Test
	public void testGetGenero() {
		assertEquals(a.getGenero().getClass(), TipoGenero.class);
	}
	
	@Test
	public void testSetGenero() {
		a.setGenero(TipoGenero.BLUES);
	}
	
	@Test
	public void testIsVerificada() {
		Boolean b = a.isVerificada();
		assertEquals(b.getClass(), Boolean.class);
	}
	
	@Test
	public void testSetVerificada() {
		a.setVerificada(true);
	}
	
}
