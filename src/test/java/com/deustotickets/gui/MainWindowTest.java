package com.deustotickets.gui;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.domain.Usuario;

public class MainWindowTest {

	@Before
	public void setUp() throws Exception {
		MainWindow.logged = new Usuario("Test", "test@example.com", "123", TipoUsuario.CLIENTE);
	}

	@After
	public void tearDown() throws Exception {
		MainWindow.logged = null;
	}
	
	@Test
	public void testInitilize() {
		MainWindow.initialize();
	}
}
