package com.deustotickets.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.UIManager;
import com.deustotickets.client.Resource;
import com.deustotickets.domain.Artista;
import com.deustotickets.domain.Concierto;
import com.deustotickets.domain.Entrada;
import com.deustotickets.domain.TipoGenero;
import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.gui.LoginWindow;

/**
 * Main program.
 * 
 * @author BSPQ-03
 */
public class App {
	public static Resource res = new Resource("127.0.0.1", "8080");
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) {
		}
		res.registerUser("Gestor1", "gestor1@deustotickets.es", "g1", TipoUsuario.GESTOR);
		res.registerUser("Cliente1", "c4", "c4", TipoUsuario.CLIENTE);
		res.addConcert("0", new Artista ("Hens", "hens@gmail.com", "123", TipoUsuario.ARTISTA, TipoGenero.POP, true), "29/02/2024", "BEC", 1110);
		res.addConcert("1", new Artista ("Juancho Marqués", "juancho@gmail.com", "123", TipoUsuario.ARTISTA, TipoGenero.POP, true), "09/02/2024", "BEC", 1110);
		res.addConcert("2", new Artista ("Rels B", "relsito@gmail.com", "123", TipoUsuario.ARTISTA, TipoGenero.POP, false), "11/02/2024", "BEC", 1110);
		res.addConcert("3", new Artista ("Prueba", "prueba@gmail.com", "123", TipoUsuario.ARTISTA, TipoGenero.POP, false), "11/02/2024", "BEC", 1110);
		
		// Este no lo coge, hay que meterlo a mano en la BBDD
		res.addConcert("4", new Artista ("Hola", "hola@gmail.com", "123", TipoUsuario.ARTISTA, TipoGenero.BLUES, false), "11/02/2022", "BEC", 1110);
		res.addConcert("5", new Artista ("Hola", "holaa@gmail.com", "123", TipoUsuario.ARTISTA, TipoGenero.BLUES, false), "11/02/2027", "BEC", 1110);
//		Entrada ent = new Entrada("1", res.getConcerts().get(0), 23.23, "Prueba");
		LoginWindow win = new LoginWindow();
		win.initialize();
	}
	
}
