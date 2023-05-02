package com.deustotickets.gui;

import static org.junit.Assert.*;

import java.awt.HeadlessException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegWindowTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInitialize() throws HeadlessException {
		try {
			RegWindow.initialize();
		} catch (HeadlessException e) {
			e.printStackTrace();			
		}
	}
}
