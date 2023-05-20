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
import org.junit.Test;
import org.mockito.Mock;

import com.deustotickets.domain.Artista;
import com.deustotickets.domain.Concierto;
import com.deustotickets.domain.Entrada;
import com.deustotickets.domain.TipoGenero;
import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.domain.Usuario;
import com.deustotickets.gui.MainWindow;

public class ResourceTest {

	@Mock
	private Client client;

	@Mock
	private WebTarget webTarget;

	@Mock
	private WebTarget userWebTarget;

	@Mock
	private Invocation.Builder invocationBuilder;

	@Mock
	private Response response;

	@Mock
	private Usuario logged;

	@Mock
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
		cl.add(new Concierto("0", a, "01/01/2000", "test", 500));
		cl.add(new Concierto("1", a, "01/01/9999", "test", 500));
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
	public void testLoginUserSuccess() {
		Usuario mockUser = new Usuario();
		mockUser.setEmail("test@example.com");
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(response.readEntity(Usuario.class)).thenReturn(mockUser);
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.loginUser("test@example.com", "password"));
	}

	@Test
	public void testLoginUserFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.loginUser("test@example.com", "password"));
	}

	@Test
	public void testRegisterUserSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.registerUser("test", "test@example.com", "password", TipoUsuario.CLIENTE));
	}

	@Test
	public void testRegisterUserFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.registerUser("test", "test@example.com", "password", TipoUsuario.CLIENTE));
	}

	@Test
	public void testCloseSessionsSuccess() {
		MainWindow.logged = new Usuario();
		assertTrue(Resource.closeSession());
	}

	@Test
	public void testCloseSessionsFailure() {
		MainWindow.logged = null;
		assertFalse(Resource.closeSession());
	}

	@Test
	public void testChangeUsernameSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.changeUsername("test1", "test@example.com"));
	}

	@Test
	public void testChangeUsernameFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.changeUsername("test1", "test@example.com"));
	}

	@Test
	public void testChangePasswordSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.changePassword("password1", "test@example.com"));
	}

	@Test
	public void testChangePasswordFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.changePassword("password1", "test@example.com"));
	}

	@Test
	public void testDeleteAccountSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.deleteAccount("test@example.com"));
	}

	@Test
	public void testDeleteAccountFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.deleteAccount("test@example.com"));
	}

	@Test
	public void testAddConcertSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.addConcert("0", new Artista(), "01/01/2000", "test", 0));
	}

	@Test
	public void testAddConcertFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.addConcert("0", new Artista(), "01/01/2000", "test", 0));
	}

	@Test
	public void testDeleteConcertSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.deleteConcert("01"));
	}

	@Test
	public void testDeleteConcertFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.deleteConcert("01"));
	}

	@Test
	public void testGetConcertsSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.get()).thenReturn(response);
		when(response.readEntity(new GenericType<ArrayList<Concierto>>() {
		})).thenReturn(new ArrayList<Concierto>());

		assertEquals(Resource.getConcerts().getClass(), ArrayList.class);
	}

	@Test
	public void testGetConcertsFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.get()).thenReturn(response);

		assertEquals(Resource.getConcerts(), null);
	}

	@Test
	public void testModifyConcertSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.modifyConcert("1", new Artista(), "01/01/2000", "test", 0));
	}

	@Test
	public void testModifyConcertFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.modifyConcert("1", new Artista(), "01/01/2000", "test", 0));
	}

	@Test
	public void testVerifyArtistSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.verifyArtist("test@example.com"));
	}

	@Test
	public void testVerifyArtistFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.verifyArtist("test@example.com"));
	}

	@Test
	public void testBanUserSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.banUser("test@example.com"));
	}

	@Test
	public void testBanUserFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.banUser("test@example.com"));
	}

	@Test
	public void testGetUsersSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.get()).thenReturn(response);
		when(response.readEntity(new GenericType<ArrayList<Usuario>>() {
		})).thenReturn(new ArrayList<Usuario>());

		assertEquals(Resource.getUsers().getClass(), ArrayList.class);
	}

	@Test
	public void testGetUsersFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.get()).thenReturn(response);

		assertEquals(Resource.getUsers(), null);
	}

	@Test
	public void testGetArtistsSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.get()).thenReturn(response);
		when(response.readEntity(new GenericType<ArrayList<Artista>>() {
		})).thenReturn(new ArrayList<Artista>());

		assertEquals(Resource.getArtists().getClass(), ArrayList.class);
	}

	@Test
	public void testGetArtistsFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.get()).thenReturn(response);

		assertEquals(Resource.getArtists(), null);
	}

	@Test
	public void testBuyTicketSuccess() {
		when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertTrue(Resource.buyTicket(
				new Entrada("TEST", new Concierto("0", new Artista(), "01/01/2000", "test", 0), 10.00, "test")));
	}

	@Test
	public void testBuyTicketFailure() {
		when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

		assertFalse(Resource.buyTicket(
				new Entrada("TEST", new Concierto("0", new Artista(), "01/01/2000", "test", 0), 10.00, "test")));
	}

	@Test
	public void testGenerateReport() {
		assertTrue(Resource.generateReport("test.txt", ul, cl, al));
		assertFalse(Resource.generateReport(null, eul, cl, al));
		assertFalse(Resource.generateReport("test.txt", eul, cl, al));
		assertFalse(Resource.generateReport("test.txt", ul, ecl, al));
		assertFalse(Resource.generateReport("test.txt", ul, cl, eal));
	}
}
