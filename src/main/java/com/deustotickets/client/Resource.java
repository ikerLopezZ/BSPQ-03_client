package com.deustotickets.client;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.deustotickets.domain.Artista;
import com.deustotickets.domain.Concierto;
import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.domain.Usuario;
import com.deustotickets.gui.MainWindow;

/**
 * 
 * @author BSPQ-03
 *
 */
public class Resource {
	protected static final Logger logger = LogManager.getLogger();
	private Client client;
	public static WebTarget webTarget;

	public Resource(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/resource", hostname, port));
	}
	
	/**
	 * 
	 * @param email {@link String}
	 * @param password {@link String}
	 * @return {@link Boolean}
	 */
	public static boolean loginUser(String email, String password) {
		WebTarget userWebTarget = webTarget.path("login");
		Invocation.Builder invocationBuilder = userWebTarget.request(MediaType.APPLICATION_JSON);
		Usuario user = new Usuario(null, email, password, null);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		Usuario u = response.readEntity(Usuario.class);
		MainWindow.logged = u;
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return false;
		} else {
			logger.info("User correctly logged in");
			System.out.println("User correctly logged in");
			return true;
		}
	}

	/**
	 * 
	 * @param nombreApellidos {@link String}
	 * @param email {@link String}
	 * @param password {@link String}
	 * @param tipo {@link TipoUsuario}
	 * @return {@link Boolean}
	 */
	public static boolean registerUser(String nombreApellidos, String email, String password, TipoUsuario tipo) {
		WebTarget userWebTarget = webTarget.path("register");
		Invocation.Builder invocationBuilder = userWebTarget.request(MediaType.APPLICATION_JSON);
		Usuario user = new Usuario(nombreApellidos, email, password, tipo);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return false;
		} else {
			logger.info("User correctly registered");
			System.out.println("User correctly registered");
			return true;
		}
	}
	
	/**
	 * 
	 * @return {@link Boolean}
	 */
	public static boolean closeSession() {
		if(MainWindow.logged != null) {
			MainWindow.logged = null;
			logger.info("Session closed");
			System.out.println("Session closed");
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param nombreApellidos
	 * @param email
	 * @return
	 */
	public static boolean changeUsername(String nombreApellidos, String email) {
		WebTarget userWebTarget = webTarget.path("changeUsername");
		Invocation.Builder invocationBuilder = userWebTarget.request(MediaType.APPLICATION_JSON);
		Usuario user = new Usuario(nombreApellidos, email, null, null);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return false;
		} else {
			logger.info("Username successfully changed");
			System.out.println("Username successfully changed");
			return true;
		}
	}
	
	/**
	 * 
	 * @param password
	 * @return
	 */
	public static boolean changePassword(String email, String password) {
		WebTarget userWebTarget = webTarget.path("changePassword");
		Invocation.Builder invocationBuilder = userWebTarget.request(MediaType.APPLICATION_JSON);
		Usuario user = new Usuario(null, email, password, null);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return false;
		} else {
			logger.info("Password successfully changed");
			System.out.println("Password successfully changed");
			return true;
		}
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	public static boolean deleteAccount(String email) {
		WebTarget registerUserWebTarget = webTarget.path("deleteAccount");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Usuario user = new Usuario(null, email, null, null);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return false;
		} else {
			logger.info("Account successfully deleted");
			System.out.println("Account successfully deleted");
			return true;
		}
	}
	
	public static boolean addConcert(int id, Artista artista, String fecha, String lugar, int aforo) {
		WebTarget registerUserWebTarget = webTarget.path("addConcert");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Concierto con = new Concierto(id, artista, fecha, lugar, aforo);
		Response response = invocationBuilder.post(Entity.entity(con, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return false;
		} else {
			logger.info("Concert successfully added");
			System.out.println("Concert successfully added");
			return true;
		}
	}
	
	public static boolean deleteConcert(int id) {
		WebTarget registerUserWebTarget = webTarget.path("deleteConcert");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Concierto con = new Concierto();
		con.setId(id);
		Response response = invocationBuilder.post(Entity.entity(con, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return false;
		} else {
			logger.info("Concert successfully added");
			System.out.println("Concert successfully added");
			return true;
		}
	}
	
	public static ArrayList<Concierto> getConcerts() {
		WebTarget registerUserWebTarget = webTarget.path("getConcerts");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return null;
		} else {
			logger.info("Got all concerts");
			System.out.println("Got all concerts");
			
			ArrayList<Concierto> ret = (ArrayList<Concierto>) response.readEntity(new GenericType<ArrayList<Concierto>>() {});
			
			return ret;
		}
	}
	
	public static boolean modifyConcert(int id, Artista artista, String fecha, String lugar, int aforo) {
		WebTarget registerUserWebTarget = webTarget.path("modifyConcert");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Concierto con = new Concierto(id, artista, fecha, lugar, aforo);
		Response response = invocationBuilder.post(Entity.entity(con, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return false;
		} else {
			logger.info("Concert successfully added");
			System.out.println("Concert successfully added");
			return true;
		}
	}
	
	public static boolean verifyArtist(String email) {
		WebTarget registerUserWebTarget = webTarget.path("verifyArtist");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Artista artista = new Artista(null, email, null, null, null, false);
		Response response = invocationBuilder.post(Entity.entity(artista, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return false;
		} else {
			logger.info("Artist verified");
			System.out.println("Artist verified");
			return true;
		}
	}
	
	public static boolean banUser(String email) {
		WebTarget registerUserWebTarget = webTarget.path("banUser");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Usuario u = new Usuario(null, email, null, null);
		Response response = invocationBuilder.post(Entity.entity(u, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return false;
		} else {
			logger.info("User banned");
			System.out.println("User banned");
			return true;
		}
	}
	
	public static ArrayList<Usuario> getUsers() {
		WebTarget getUsersWebTarget = webTarget.path("getUsers");
		Invocation.Builder invocationBuilder = getUsersWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return null;
		} else {
			logger.info("Users successfully recovered");
			System.out.println("Users successfully recovered");
			return (ArrayList<Usuario>) response.readEntity(ArrayList.class);
		}
	}
	
	public static ArrayList<Artista> getArtists() {
		WebTarget getArtistsWebTarget = webTarget.path("getArtists");
		Invocation.Builder invocationBuilder = getArtistsWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return null;
		} else {
			logger.info("Artists successfully recovered");
			System.out.println("Artists successfully recovered");
			return (ArrayList<Artista>) response.readEntity(ArrayList.class);
		}
	}
}