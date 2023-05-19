package com.deustotickets.client;

import java.io.File;
import java.io.PrintWriter;
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
import com.deustotickets.domain.Entrada;
import com.deustotickets.domain.TipoGenero;
import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.domain.Usuario;
import com.deustotickets.gui.MainWindow;

/**
 * Class that manages all interaction with the server.
 * It contains all the methods that give functionality to the application.
 * 
 * @author BSPQ-03
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
	 * Logs in with the user's account.
	 * 
	 * @param email e-mail of the user
	 * @param password password of the user
	 * @return true if the login is successful and false if it is not
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
	 * Registers the user.
	 * 
	 * @param nombreApellidos first and last name of the user
	 * @param email e-mail of the user
	 * @param password password of the user
	 * @param tipo type of user of the user
	 * @return true if the login is successful and false if it is not
	 * @see TipoUsuario
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
	 * Logs out the user.
	 * 
	 * @return true if the logout is successful and false if it is not
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
	 * Changes the user's username. 
	 * 
	 * @param nombreApellidos first and last name of the user
	 * @param email e-mail of the user
	 * @return true if the username change is successful and false if it is not
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
	 * Changes the user's password.
	 * 
	 * @param email e-mail of the user
	 * @param password password of the user
	 * @return true if the password change is successful and false if it is not
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
	 * Deletes the user's account.
	 * 
	 * @param email e-mail of the user
	 * @return true if the account deletion is successful and false if it is not
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
	 * Adds a concert.
	 * 
	 * @param id concert id
	 * @param artista artist associated with the concert
	 * @param fecha concert date
	 * @param lugar place where the concert is held
	 * @param aforo concert capacity
	 * @return true if the concert addition is successful and false if it is not
	 * @see Artista
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
	 * Deletes a concert.
	 * 
	 * @param id concert id
	 * @return true if the concert deletion is successful and false if it is not
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
	 * Buys a concert ticket.
	 * 
	 * @param ent concert ticket to buy
	 * @return true if the ticket purchase is successful and false if it is not
	 * @see Entrada
	 */
	public static boolean buyTicket(Entrada ent) {
		WebTarget registerUserWebTarget = webTarget.path("buyTicket");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(ent, MediaType.APPLICATION_JSON));
		ArrayList<Entrada> mine = MainWindow.logged.getMisEntradas();
		mine.add(ent);
		MainWindow.logged.setMisEntradas(mine);
		updateUserTickets(MainWindow.logged);
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return false;
		} else {
			logger.info("Ticket successfully bought");
			System.out.println("Ticket successfully bought");
			return true;
		}
	}
	
	/**
	 * Updates the user concert tickets.
	 * 
	 * @param u user whose concert tickets are to be updated
	 * @return true if the user ticket update is successful and false if it is not
	 * @see Usuario
	 */
	public static boolean updateUserTickets(Usuario u) {
		WebTarget registerUserWebTarget = webTarget.path("updateUserTickets");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(u, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			System.out.println("Error connecting with the server");
			return false;
		} else {
			logger.info("User updated");
			System.out.println("User updated");
			return true;
		}
	}

	/**
	 * Gets all the concerts.
	 * 
	 * @return an ArrayList with all concerts
	 * @see Concierto
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
	 * Modifies a concert.
	 * 
	 * @param id concert id
	 * @param artista artist associated with the concert
	 * @param fecha concert date
	 * @param lugar place where the concert is held
	 * @param aforo concert capacity
	 * @return true if the concert modification is successful and false if it is not
	 * @see Artista
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
	 * Verifies an artist.
	 * 
	 * @param email e-mail of the artist
	 * @return true if the artist verification is successful and false if it is not
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
	 * Bans a user.
	 * 
	 * @param email e-mail of the user
	 * @return true if the user ban is successful and false if it is not
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
	 * Gets all the users.
	 * 
	 * @return an ArrayList with all users
	 * @see Usuario
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
	 * Gets all the artists.
	 * 
	 * @return an ArrayList with all artists
	 * @see Artista
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
	 * Generates a report with the application's statistics.
	 * 
	 * @param filename file name
	 * @param usuarios list with all users
	 * @param conciertos list with all concerts
	 * @param artistas list with all artists
	 * @return true if the report generation is successful and false if it is not
	 * @see Usuario
	 * @see Concierto
	 */
	public static boolean generateReport(String filename, List<Usuario> usuarios, List<Concierto> conciertos,
			List<Artista> artistas) {
		if (filename != null && !usuarios.isEmpty() && !conciertos.isEmpty() && !artistas.isEmpty()) {
			try (PrintWriter out = new PrintWriter(new File(filename))) {
				String dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm:ss").format(LocalDateTime.now());
				Date actual;
				ArrayList<TipoGenero> generosActuales = new ArrayList<TipoGenero>();
				HashMap<TipoGenero, Integer> generos = new HashMap<TipoGenero, Integer>();
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
				
				return true;

			} catch (Exception ex) {
				System.err.println(String.format("Error escribiendo TXT '%s': %s", filename, ex.getMessage()));
				return false;
			}
		} else {
			System.out.println("- No se puede escribir el fichero TXT.");
			return false;
		}
	}

}
