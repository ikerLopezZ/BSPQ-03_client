package com.deustotickets.app;

import javax.swing.UIManager;

import com.deustotickets.client.Resource;
import com.deustotickets.domain.TipoUsuario;

import com.deustotickets.gui.LoginWindow;

/**
 * 
 * @author BSPQ-03
 *
 */
public class App {
	public static Resource res = new Resource("127.0.0.1", "8080");
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) {
		}
		res.registerUser("Gestor1", "gestor1@deustotickets.es", "g1", TipoUsuario.GESTOR);
		res.registerUser("Gestor2", "gestor2@deustotickets.es", "g2", TipoUsuario.GESTOR);
		res.registerUser("Gestor3", "gestor3@deustotickets.es", "g3", TipoUsuario.GESTOR);
		res.registerUser("Gestor4", "gestor4@deustotickets.es", "g4", TipoUsuario.GESTOR);
		res.registerUser("Gestor5", "gestor5@deustotickets.es", "g5", TipoUsuario.GESTOR);
		LoginWindow win = new LoginWindow();
		win.initialize();
	}
}
