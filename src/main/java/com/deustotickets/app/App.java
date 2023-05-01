package com.deustotickets.app;

import javax.swing.UIManager;
import com.deustotickets.client.Resource;
import com.deustotickets.domain.Artista;
import com.deustotickets.domain.TipoGenero;
import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.domain.Usuario;
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
		res.addConcert(0, new Artista ("Hens", "hens@gmail.com", "123", TipoUsuario.ARTISTA, TipoGenero.POP, true), "29/02/2024", "BEC", 1110);
		res.addConcert(1, new Artista ("Juancho Marqués", "juancho@gmail.com", "123", TipoUsuario.ARTISTA, TipoGenero.POP, true), "09/02/2024", "BEC", 1110);
		LoginWindow win = new LoginWindow();
		System.out.println(res.getUsers());
		System.out.println(res.getArtists());
		System.out.println(res.getConcerts());
		win.initialize();
	}
}