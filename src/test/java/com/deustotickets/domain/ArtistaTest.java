package com.deustotickets.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArtistaTest {
	
	Usuario u;

	@Before
	public void setUp() throws Exception {
		u = new Usuario("Test", "test@example.com", "123", TipoUsuario.CLIENTE);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetNombreApellidos() {
		assertEquals(u.getNombreApellidos().getClass(), String.class);
	}
	
	@Test
	public void testSetNombreApellidos() {
		u.setNombreApellidos("Test");
	}

	@Test
	public void testGetEmail() {
		assertEquals(u.getEmail().getClass(), String.class);
	}
	
	@Test
	public void testSetEmail() {
		u.setEmail("test@example.com");
	}
	
	@Test
	public void testGetPassword() {
		assertEquals(u.getPassword().getClass(), String.class);
	}
	
	@Test
	public void testSetPassword() {
		u.setPassword("123");
	}
	
	@Test
	public void testGetTipo() {
		assertEquals(u.getTipo().getClass(), TipoUsuario.class);
	}
	
	@Test
	public void testSetTipo() {
		u.setTipo(TipoUsuario.CLIENTE);
	}
	
	@Test
	public void testIsBanned() {
		Boolean b = u.isBanned();
		assertEquals(b.getClass(), Boolean.class);
	}
	
	@Test
	public void testSetBanned() {
		u.setBanned(false);
	}
	
	@Test
	public void testToString() {
		assertEquals(u.toString(), "Usuario [nombre y apellidos=Test, email=test@example.com, password=123, tipo=CLIENTE]");
	}
}
