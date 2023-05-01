package com.deustotickets.gui;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.deustotickets.domain.Usuario;

public class MainWindowTest {

	@Before
	public void setUp() throws Exception {
		MainWindow.logged = new Usuario();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInitilize() {
		MainWindow.initialize();
	}
}
