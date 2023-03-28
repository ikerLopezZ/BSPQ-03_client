package com.deustotickets.app;

import javax.swing.UIManager;

import com.deustotickets.domain.TipoUsuario;

import com.deustotickets.gui.LoginWindow;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) {
		}
		Resource res = new Resource("127.0.0.1", "8080");
		res.registerUser("Gestor1", "gestor1@deustotickets.es", "g1", TipoUsuario.GESTOR);
		LoginWindow win = new LoginWindow();
		win.initialize();
	}
}
