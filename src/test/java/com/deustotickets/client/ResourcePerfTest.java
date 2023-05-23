package com.deustotickets.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import com.deustotickets.domain.Artista;
import com.deustotickets.domain.Concierto;
import com.deustotickets.domain.Entrada;
import com.deustotickets.domain.TipoGenero;
import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.domain.Usuario;
import com.deustotickets.gui.MainWindow;
import com.github.javatlacati.contiperf.PerfTest;
import com.github.javatlacati.contiperf.Required;
import com.github.javatlacati.contiperf.junit.ContiPerfRule;


public class ResourcePerfTest {
	
	@Rule 
	public ContiPerfRule rule = new ContiPerfRule();

	
	private Client client;

	private WebTarget webTarget;

	private WebTarget userWebTarget;

	private Invocation.Builder invocationBuilder;

	private Response response;

	private Usuario logged;

	private MainWindow mainwindow;

	Artista a;
	Artista b;
	Concierto c;
	List<Usuario> ul;
	List<Concierto> cl;
	List<Artista> al;
	List<Usuario> eul;
	List<Concierto> ecl;
	List<Artista> eal;

	@Before
	public void setUp() {
		a = new Artista("test", "test@example.com", "password", TipoUsuario.ARTISTA, TipoGenero.POP, true);
		b = new Artista("test", "test@example.com", "password", TipoUsuario.ARTISTA, TipoGenero.BLUES, true);
		ul = new ArrayList<Usuario>();
		ul.add(new Usuario("test", "test@example.com", "password", TipoUsuario.CLIENTE));
		cl = new ArrayList<Concierto>();
		cl.add(new Concierto("0", a, "01/01/2000", "test", 300));
		cl.add(new Concierto("1", a, "01/01/9999", "test", 300));
		al = new ArrayList<Artista>();
		al.add(a);
		al.add(b);
		eul = new ArrayList<Usuario>();
		ecl = new ArrayList<Concierto>();
		eal = new ArrayList<Artista>();
		MainWindow.logged = new Usuario("test", "test@example.com", "password", TipoUsuario.CLIENTE);
		client = mock(Client.class);
		webTarget = mock(WebTarget.class);
		userWebTarget = mock(WebTarget.class);
		invocationBuilder = mock(Invocation.Builder.class);
		response = mock(Response.class);
		logged = mock(Usuario.class);
		mainwindow = mock(MainWindow.class);
		Resource.webTarget = webTarget;
		when(client.target(any(String.class))).thenReturn(webTarget);
		when(webTarget.path(any(String.class))).thenReturn(userWebTarget);
		when(userWebTarget.request(MediaType.APPLICATION_JSON)).thenReturn(invocationBuilder);
		when(logged.getMisEntradas()).thenReturn(new ArrayList<Entrada>());
	}
	
	@After
	public void tearDown() {
		File f = new File("test.txt");
		f.delete();
	}


	@Test
	public void testResource() {
		new Resource("localhost", "8080");
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testRegisterUserSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.registerUser("test", "test@example.com", "password", TipoUsuario.CLIENTE));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testRegisterUserFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.registerUser("test", "test@example.com", "password", TipoUsuario.CLIENTE));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testChangeUsernameSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.changeUsername("test1", "test@example.com"));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testChangeUsernameFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.changeUsername("test1", "test@example.com"));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testChangePasswordSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.changePassword("password1", "test@example.com"));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testChangePasswordFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.changePassword("password1", "test@example.com"));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testDeleteAccountSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.deleteAccount("test@example.com"));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testDeleteAccountFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.deleteAccount("test@example.com"));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testAddConcertSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.addConcert("0", new Artista(), "01/01/2000", "test", 0));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testAddConcertFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.addConcert("0", new Artista(), "01/01/2000", "test", 0));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testDeleteConcertSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.deleteConcert("01"));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testDeleteConcertFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.deleteConcert("01"));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testGetConcertsFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.get()).thenReturn(response);

		assertEquals(Resource.getConcerts(), null);
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testModifyConcertSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.modifyConcert("1", new Artista(), "01/01/2000", "test", 0));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testModifyConcertFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.modifyConcert("1", new Artista(), "01/01/2000", "test", 0));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testVerifyArtistSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.verifyArtist("test@example.com"));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testVerifyArtistFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.verifyArtist("test@example.com"));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testBanUserSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.banUser("test@example.com"));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testBanUserFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.banUser("test@example.com"));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testGetUsersFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.get()).thenReturn(response);

		assertEquals(Resource.getUsers(), null);
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testGetArtistsFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.get()).thenReturn(response);

		assertEquals(Resource.getArtists(), null);
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testBuyTicketSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.buyTicket(
				new Entrada("TEST", new Concierto("0", new Artista(), "01/01/2000", "test", 0), 10.00, "test")));
	}

	@Test
	@Required(totalTime = 1000)
	@PerfTest(invocations = 30, threads = 3)
	public void testBuyTicketFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.buyTicket(
				new Entrada("TEST", new Concierto("0", new Artista(), "01/01/2000", "test", 0), 10.00, "test")));
	}
}
