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
	
	
	public static boolean deleteAccount(String email) {
	    // Crear un objeto WebTarget para apuntar a la ruta "deleteAccount" de la API
	    WebTarget registerUserWebTarget = webTarget.path("deleteAccount");
	    
	    // Crear un objeto Invocation.Builder para construir la solicitud HTTP
	    Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
	    
	    // Crear un objeto Usuario con el correo electrónico de la cuenta que se va a eliminar
	    Usuario user = new Usuario(null, email, null, null);
	    
	    // Enviar una solicitud POST con el objeto Usuario como cuerpo de la solicitud
	    Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
	    
	    // Verificar si la respuesta del servidor fue exitosa o no
	    if (response.getStatus() != Status.OK.getStatusCode()) {
	        // Si no fue exitosa, imprimir un mensaje de error y devolver false
	        logger.error("Error connecting with the server. Code: {}", response.getStatus());
	        System.out.println("Error connecting with the server");
	        return false;
	    } else {
	        // Si fue exitosa, imprimir un mensaje de éxito y devolver true
	        logger.info("Account successfully deleted");
	        System.out.println("Account successfully deleted");
	        return true;
	    }
	}

	
	public static boolean addConcert(int id, Artista artista, String fecha, String lugar, int aforo) {
	    // Crear un objeto WebTarget para apuntar a la ruta "addConcert" de la API
	    WebTarget registerUserWebTarget = webTarget.path("addConcert");
	    
	    // Crear un objeto Invocation.Builder para construir la solicitud HTTP
	    Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
	    
	    // Crear un objeto Concierto con los datos del concierto que se va a agregar
	    Concierto con = new Concierto(id, artista, fecha, lugar, aforo);
	    
	    // Enviar una solicitud POST con el objeto Concierto como cuerpo de la solicitud
	    Response response = invocationBuilder.post(Entity.entity(con, MediaType.APPLICATION_JSON));
	    
	    // Verificar si la respuesta del servidor fue exitosa o no
	    if (response.getStatus() != Status.OK.getStatusCode()) {
	        // Si no fue exitosa, imprimir un mensaje de error y devolver false
	        logger.error("Error connecting with the server. Code: {}", response.getStatus());
	        System.out.println("Error connecting with the server");
	        return false;
	    } else {
	        // Si fue exitosa, imprimir un mensaje de éxito y devolver true
	        logger.info("Concert successfully added");
	        System.out.println("Concert successfully added");
	        return true;
	    }
	}

	

	 //Elimina un concierto del servidor.
	 
	public static boolean deleteConcert(int id) {
	    // Se define el WebTarget para la ruta "deleteConcert" en el servidor
	    WebTarget registerUserWebTarget = webTarget.path("deleteConcert");
	    // Se crea un Invocation.Builder con el tipo de medio APPLICATION_JSON
	    Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
	    // Se crea un objeto Concierto con el ID especificado
	    Concierto con = new Concierto();
	    con.setId(id);
	    // Se envía la petición POST con el objeto Concierto en el cuerpo
	    Response response = invocationBuilder.post(Entity.entity(con, MediaType.APPLICATION_JSON));
	    // Si el código de estado de la respuesta es diferente a 200 OK, se retorna false
	    if (response.getStatus() != Status.OK.getStatusCode()) {
	        logger.error("Error connecting with the server. Code: {}", response.getStatus());
	        System.out.println("Error connecting with the server");
	        return false;
	    } else {
	        // Si el código de estado de la respuesta es 200 OK, se muestra un mensaje de éxito y se retorna true
	        logger.info("Concert successfully added");
	        System.out.println("Concert successfully added");
	        return true;
	    }
	}

	
	//Obtiene una lista de todos los conciertos almacenados en el servidor
	public static ArrayList<Concierto> getConcerts() {
	    // Se define el WebTarget para la ruta "getConcerts" en el servidor
	    WebTarget registerUserWebTarget = webTarget.path("getConcerts");
	    // Se crea un Invocation.Builder con el tipo de medio APPLICATION_JSON
	    Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
	    // Se envía la petición GET
	    Response response = invocationBuilder.get();
	    // Si el código de estado de la respuesta es diferente a 200 OK, se retorna null
	    if (response.getStatus() != Status.OK.getStatusCode()) {
	        logger.error("Error connecting with the server. Code: {}", response.getStatus());
	        System.out.println("Error connecting with the server");
	        return null;
	    } else {
	        // Si el código de estado de la respuesta es 200 OK, se convierte la respuesta a una ArrayList de Concierto y se retorna
	        logger.info("Got all concerts");
	        System.out.println("Got all concerts");
	        ArrayList<Concierto> ret = (ArrayList<Concierto>) response.readEntity(new GenericType<ArrayList<Concierto>>() {});
	        return ret;
	    }
	}
	
	//Modifica un concierto existente en el servidor con los datos proporcionados
	public static boolean modifyConcert(int id, Artista artista, String fecha, String lugar, int aforo) {
	    // Se define el WebTarget para la ruta "modifyConcert" en el servidor
	    WebTarget registerUserWebTarget = webTarget.path("modifyConcert");
	    // Se crea un Invocation.Builder con el tipo de medio APPLICATION_JSON
	    Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
	    // Se crea un objeto Concierto con los datos proporcionados
	    Concierto con = new Concierto(id, artista, fecha, lugar, aforo);
	    // Se envía la petición POST con el objeto Concierto en el cuerpo de la petición
	    Response response = invocationBuilder.post(Entity.entity(con, MediaType.APPLICATION_JSON));
	    // Si el código de estado de la respuesta es diferente a 200 OK, se retorna false
	    if (response.getStatus() != Status.OK.getStatusCode()) {
	        logger.error("Error connecting with the server. Code: {}", response.getStatus());
	        System.out.println("Error connecting with the server");
	        return false;
	    } else {
	        // Si el código de estado de la respuesta es 200 OK, se retorna true
	        logger.info("Concert successfully added");
	        System.out.println("Concert successfully added");
	        return true;
	    }
	}
	
	// Definimos una función que toma una dirección de correo electrónico de artista y la utiliza para verificar su cuenta de artista
	public static boolean verifyArtist(String email) {
			
	    // Creamos un objeto WebTarget para definir la URL de la solicitud
	    WebTarget registerUserWebTarget = webTarget.path("verifyArtist");

	    // Creamos un objeto Invocation.Builder para definir los parámetros de la solicitud
	    Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

	    // Creamos un objeto Artista con la dirección de correo electrónico especificada y el estado "no verificado"
	    Artista artista = new Artista(null, email, null, null, null, false);

	    // Hacemos la solicitud HTTP para verificar la cuenta del artista
	    Response response = invocationBuilder.post(Entity.entity(artista, MediaType.APPLICATION_JSON));

	    // Verificamos si la respuesta tiene un estado OK
	    if (response.getStatus() != Status.OK.getStatusCode()) {
	        logger.error("Error connecting with the server. Code: {}", response.getStatus());
	        System.out.println("Error connecting with the server");
	        return false; // Si la respuesta no tiene un estado OK, devolvemos "false"
	    } else {
	        logger.info("Artist verified");
	        System.out.println("Artist verified");
	        return true; // Si la respuesta tiene un estado OK, devolvemos "true"
	    }
	}

	
	// Definimos una función que toma una dirección de correo electrónico de usuario y la utiliza para prohibir el acceso a ese usuario
	public static boolean banUser(String email) {
			
	    // Creamos un objeto WebTarget para definir la URL de la solicitud
	    WebTarget registerUserWebTarget = webTarget.path("banUser");

	    // Creamos un objeto Invocation.Builder para definir los parámetros de la solicitud
	    Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

	    // Creamos un objeto Usuario con la dirección de correo electrónico especificada
	    Usuario u = new Usuario(null, email, null, null);

	    // Hacemos la solicitud HTTP para prohibir el acceso al usuario
	    Response response = invocationBuilder.post(Entity.entity(u, MediaType.APPLICATION_JSON));

	    // Verificamos si la respuesta tiene un estado OK
	    if (response.getStatus() != Status.OK.getStatusCode()) {
	        logger.error("Error connecting with the server. Code: {}", response.getStatus());
	        System.out.println("Error connecting with the server");
	        return false; // Si la respuesta no tiene un estado OK, devolvemos "false"
	    } else {
	        logger.info("User banned");
	        System.out.println("User banned");
	        return true; // Si la respuesta tiene un estado OK, devolvemos "true"
	    }
	}

	
	// Definimos una función que devuelve una lista de objetos Usuario
	public static ArrayList<Usuario> getUsers() {
			
	    // Creamos un objeto WebTarget para definir la URL de la solicitud
	    WebTarget getUsersWebTarget = webTarget.path("getUsers");

	    // Creamos un objeto Invocation.Builder para definir los parámetros de la solicitud
	    Invocation.Builder invocationBuilder = getUsersWebTarget.request(MediaType.APPLICATION_JSON);

	    // Hacemos la solicitud HTTP para obtener la respuesta
	    Response response = invocationBuilder.get();

	    // Verificamos si la respuesta tiene un estado OK
	    if (response.getStatus() != Status.OK.getStatusCode()) {
	        logger.error("Error connecting with the server. Code: {}", response.getStatus());
	        System.out.println("Error connecting with the server");
	        return null; // Si la respuesta no tiene un estado OK, devolvemos un valor nulo
	    } else {
	        logger.info("Users successfully recovered");
	        System.out.println("Users successfully recovered");
	        // Si la respuesta tiene un estado OK, devolvemos la lista de objetos Usuario obtenida de la entidad de respuesta
	        return (ArrayList<Usuario>) response.readEntity(ArrayList.class);
	    }
	}

	
	// Definimos una función que devuelve una lista de objetos Artista
	public static ArrayList<Artista> getArtists() {
		// Creamos un objeto WebTarget para definir la URL de la solicitud
		WebTarget getArtistsWebTarget = webTarget.path("getArtists");
		// Creamos un objeto Invocation.Builder para definir los parámetros de la solicitud
		Invocation.Builder invocationBuilder = getArtistsWebTarget.request(MediaType.APPLICATION_JSON);
		// Hacemos la solicitud HTTP para obtener la respuesta
		Response response = invocationBuilder.get();
		// Verificamos si la respuesta tiene un estado OK
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