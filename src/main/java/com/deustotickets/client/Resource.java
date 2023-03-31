package com.deustotickets.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	private static WebTarget webTarget;

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
		WebTarget loginUserWebTarget = webTarget.path("login");
		Invocation.Builder invocationBuilder = loginUserWebTarget.request(MediaType.APPLICATION_JSON);
		Usuario user = new Usuario(null, email, password, null);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		Usuario u = response.readEntity(Usuario.class);
		MainWindow.logged = u;
		System.out.println(u.getEmail());
		logger.info(u.getEmail());
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
		WebTarget registerUserWebTarget = webTarget.path("register");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
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
		WebTarget registerUserWebTarget = webTarget.path("changeUsername");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
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
		WebTarget registerUserWebTarget = webTarget.path("changePassword");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
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
}