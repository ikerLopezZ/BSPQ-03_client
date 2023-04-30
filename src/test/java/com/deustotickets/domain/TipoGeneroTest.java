package com.deustotickets.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TipoGeneroTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTipoGenero() {
		for(TipoUsuario tu : TipoUsuario.values()) {
			assertEquals(tu.getClass(), TipoUsuario.class);
		}
	}

}
