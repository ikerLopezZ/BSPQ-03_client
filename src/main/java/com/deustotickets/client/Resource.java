package com.deustotickets.client;

import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.deustotickets.domain.TipoGenero;
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
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Resource(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/resource", hostname, port));
	}

	/**
	 * Método de inicio de sesión de un usuario
	 * 
	 * @param email    {@link String}
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
	 * Método de registro de un usuario
	 * 
	 * @param nombreApellidos {@link String}
	 * @param email           {@link String}
	 * @param password        {@link String}
	 * @param tipo            {@link TipoUsuario}
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
	 * Método para cerrar la sesión de un usuario
	 * 
	 * @return {@link Boolean}
	 */
	public static boolean closeSession() {
		if (MainWindow.logged != null) {
			MainWindow.logged = null;
			logger.info("Session closed");
			System.out.println("Session closed");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método para cambiar el nombre de usuario de un usuario
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
	 * Método para cambiar la contraseña de un usuario
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
	 * Método para borrar la cuenta de un usuario
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

	/**
	 * Método para añadir un concierto a la BBDD de DeustoTickets
	 * 
	 * @param id
	 * @param artista
	 * @param fecha
	 * @param lugar
	 * @param aforo
	 * @return
	 */
	public static boolean addConcert(String id, Artista artista, String fecha, String lugar, int aforo) {
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

	/**
	 * Método para borrar un concierto de la BBDD de DeustoTickets
	 * 
	 * @param id
	 * @return
	 */
	public static boolean deleteConcert(String id) {
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

	/**
	 * Método para recuperar todo los conciertos de la BBDD de DeustoTickets
	 * 
	 * @return
	 */
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

			ArrayList<Concierto> ret = (ArrayList<Concierto>) response
					.readEntity(new GenericType<ArrayList<Concierto>>() {
					});

			return ret;
		}
	}

	/**
	 * Método para modificar un concierto de la BBDD de DeustoTickets
	 * 
	 * @param id
	 * @param artista
	 * @param fecha
	 * @param lugar
	 * @param aforo
	 * @return
	 */
	public static boolean modifyConcert(String id, Artista artista, String fecha, String lugar, int aforo) {
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

	/**
	 * Método para verificar un artista en DeustoTickets
	 * 
	 * @param email
	 * @return
	 */
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

	/**
	 * Método para bloquear a un usuario de DeustoTickets
	 * @param email
	 * @return
	 */
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

	/**
	 * Método para recuperar todos los usuarios de la BBDD
	 * @return
	 */
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
			ArrayList<Usuario> ret = (ArrayList<Usuario>) response.readEntity(new GenericType<ArrayList<Usuario>>() {
			
			});

			return ret;
		}
	}

	/**
	 * Método para recuperar todos los artistas de la BBDD
	 * @return
	 */
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
			ArrayList<Artista> ret = (ArrayList<Artista>) response.readEntity(new GenericType<ArrayList<Artista>>() {
			});

			return ret;
		}
	}

	/**
	 * Método para generar un informe con las estadísticas de DeustoTickets
	 * @param filename
	 * @param usuarios
	 * @param conciertos
	 * @param artistas
	 */
	public static void generateReport(String filename, List<Usuario> usuarios, List<Concierto> conciertos,
			List<Artista> artistas) {
		if (filename != null && !usuarios.isEmpty() && !conciertos.isEmpty() && !artistas.isEmpty()) {
			try (PrintWriter out = new PrintWriter(new File(filename))) {
				String dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm:ss").format(LocalDateTime.now());
				Date actual;
				ArrayList<TipoGenero> generosActuales = new ArrayList<>();
				HashMap<TipoGenero, Integer> generos = new HashMap<>();
				actual = sdf.parse(dateTime);
				out.println("ESTADÍSTICAS DeustoTickets");
				out.println("---------------------------");

				out.println("\nUSUARIOS");
				out.println("---------");

				int contadorUsuarios = 0;
				for (Usuario u : usuarios) {
					contadorUsuarios++;
				}
				out.println("Número de usuarios en el sistema: " + contadorUsuarios);

				out.println("\n\nARITSTAS");
				out.println("---------");

				int contadorArtistas = 0;
				for (Artista a : artistas) {
					contadorArtistas++;
					if (!generosActuales.contains(a.getGenero())) {
						generos.put(a.getGenero(), 0);
					}
				}

				for (Artista a : artistas) {
					for (Map.Entry<TipoGenero, Integer> entry : generos.entrySet()) {
						if (entry.getKey().equals(a.getGenero())) {
							entry.setValue(entry.getValue() + 1);
						}
					}

				}
				out.println("Número de artistas en el sistema: " + contadorArtistas);
				out.println("\nGéneros musicales de los artistas de DeustoTickets:");
				int cont = 1;
				for (Map.Entry<TipoGenero, Integer> entry : generos.entrySet()) {
					out.println("	Nº " + cont + ": " + entry.getKey() + ", " + entry.getValue() + " artistas:");
					for (Artista a : artistas) {
						if (entry.getKey().equals(a.getGenero())) {
							out.println("		- " + a.getNombreApellidos());
						}
					}
					cont++;
				}

				out.println("\n\nCONCIERTOS");
				out.println("-----------");
				int contadorConciertos = 0;
				for (Concierto c : conciertos) {
					contadorConciertos++;
				}
				out.println("Número de conciertos registrados en el sistema: " + contadorConciertos);

				int conciertosFuturos = 0;
				int conciertosPasados = 0;

				for (Concierto c : conciertos) {
					Date fechaConcierto;
					try {
						fechaConcierto = sdf.parse(c.getFecha());
					} catch (Exception e) {
						fechaConcierto = new Date(System.currentTimeMillis());
					}
					if (fechaConcierto.after(actual)) {
						conciertosFuturos++;
					} else {
						conciertosPasados++;
					}
				}
				out.println("\n	CONCIERTOS FUTUROS: " + conciertosFuturos);
				int contador2 = 1;
				for(Concierto c : conciertos) {
					out.println("\n 		Nº" + contador2 + ": [Artista: "+c.getArtista().getNombreApellidos() + ", fecha: " + c.getFecha() + ", lugar: " + c.getLugar()+ "]");
					out.println(			"			Aforo: " + c.getAforo()); 
					out.println(			"			Entradas vendidas: " + (c.getAforo() - c.getEntradasDisponibles())); 
					out.println(			"			Entradas disponibles: " + c.getEntradasDisponibles());
					contador2++;
				}
				
				out.println("\n	CONCIERTOS PASADOS: " + conciertosPasados);
				int contador3 = 1;
				for(Concierto c : conciertos) {
					out.println("\n 		Nº" + contador3 + ": [Artista: "+c.getArtista().getNombreApellidos() + ", fecha: " + c.getFecha() + ", lugar: " + c.getLugar()+ "]");
					out.println(			"			Entradas vendidas: " + (c.getAforo() - c.getEntradasDisponibles()));
					contador3++;
				}

				out.println("\n---------------------------------------------------------------");
				

				out.println("Fecha y hora de la generación del informe: " + dateTime);

				System.out.println(String.format("'%s' Report successfully generated.", filename));

			} catch (Exception ex) {
				System.err.println(String.format("Error escribiendo TXT '%s': %s", filename, ex.getMessage()));
			}
		} else {
			System.out.println("- No se puede escribir el fichero TXT.");
		}
	}

}
