package com.deustotickets.gui;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.awt.HeadlessException;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.domain.Usuario;

public class ProfileWindowTest {

	@Mock
	private Response response;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		when(response.getStatus()).thenReturn(200);
		MainWindow.logged = new Usuario("Test", "test@example.com", "123", TipoUsuario.CLIENTE);
	}

	@After
	public void tearDown() throws Exception {
		MainWindow.logged = null;
	}
	
	@Test
	public void testInitialize() {
//		try {
//			ProfileWindow.initialize();
//		} catch (HeadlessException e) {
//			e.printStackTrace();			
//		}
	}
	
//	@Test
//	public void testChangeUsername() {
//		ProfileWindow.changeUsername();
//	}
//	
//	@Test
//	public void testChangePassword() {
//		ProfileWindow.changePassword();
//	}

}
