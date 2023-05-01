package com.deustotickets.gui;

import static org.junit.Assert.*;

import javax.swing.JSpinner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testModifySpinner() {
		JSpinner spinnerTest = new JSpinner();
		spinnerTest = Utils.modifySpinner(spinnerTest);
	}

}
