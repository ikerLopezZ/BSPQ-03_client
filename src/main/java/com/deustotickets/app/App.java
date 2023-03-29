package com.deustotickets.app;

import javax.swing.UIManager;

import com.deustotickets.client.Resource;
import com.deustotickets.domain.TipoUsuario;

import com.deustotickets.gui.LoginWindow;



public class App {
	public static Resource res = new Resource("127.0.0.1", "8080");
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) {
		}
		res.registerUser("Gestor1", "gestor1@deustotickets.es", "g1", TipoUsuario.GESTOR);
		LoginWindow win = new LoginWindow();
		win.initialize();
	}
}
