package com.deustotickets.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.deustotickets.domain.Artista;
import com.deustotickets.domain.Concierto;
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

    @Before
    public void setUp() {
        client = mock(Client.class);
        webTarget = mock(WebTarget.class);
        userWebTarget = mock(WebTarget.class);
        invocationBuilder = mock(Invocation.Builder.class);
        response = mock(Response.class);
        Resource.webTarget = webTarget;
        when(client.target(any(String.class))).thenReturn(webTarget);
        when(webTarget.path(any(String.class))).thenReturn(userWebTarget);
        when(userWebTarget.request(MediaType.APPLICATION_JSON)).thenReturn(invocationBuilder);
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

        assertTrue(Resource.registerUser("test","test@example.com", "password", TipoUsuario.CLIENTE));
    }

    @Test
    public void testRegisterUserFailure() {
        when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        when(invocationBuilder.post(any(Entity.class))).thenReturn(response);

        assertFalse(Resource.registerUser("test","test@example.com", "password", TipoUsuario.CLIENTE));
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
        when(response.readEntity(new GenericType<ArrayList<Concierto>>() {})).thenReturn(new ArrayList<Concierto>());

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
        when(response.readEntity(ArrayList.class)).thenReturn(new ArrayList<Usuario>());

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
        when(response.readEntity(ArrayList.class)).thenReturn(new ArrayList<Artista>());

        assertEquals(Resource.getArtists().getClass(), ArrayList.class);
    }
    
    @Test
    public void testGetArtistsFailure() {
        when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        when(invocationBuilder.get()).thenReturn(response);

        assertEquals(Resource.getArtists(), null);
    }
    
}
