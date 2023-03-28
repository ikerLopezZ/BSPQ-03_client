package com.deustotickets.app;


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

public class Resource {

	protected static final Logger logger = LogManager.getLogger();

	private Client client;
	private WebTarget webTarget;

	public Resource(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/resource", hostname, port));
	}

	public void registerUser(String nombreApellidos, String email, String password, TipoUsuario tipo) {
		WebTarget registerUserWebTarget = webTarget.path("register");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		
		Usuario user = new Usuario(nombreApellidos, email, password, tipo);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		} else {
			logger.info("User correctly registered");
		}
	}

//	public void sayMessage(String login, String password, String message) {
//		WebTarget sayHelloWebTarget = webTarget.path("sayMessage");
//		Invocation.Builder invocationBuilder = sayHelloWebTarget.request(MediaType.APPLICATION_JSON);
//
//		DirectMessage directMessage = new DirectMessage();
//		UserData userData = new UserData();
//		userData.setLogin(login);
//		userData.setPassword(password);
//
//		directMessage.setUserData(userData);
//
//		MessageData messageData = new MessageData();
//		messageData.setMessage(message);
//		directMessage.setMessageData(messageData);
//
//		Response response = invocationBuilder.post(Entity.entity(directMessage, MediaType.APPLICATION_JSON));
//		if (response.getStatus() != Status.OK.getStatusCode()) {
//			logger.error("Error connecting with the server. Code: {}",response.getStatus());
//		} else {
//			String responseMessage = response.readEntity(String.class);
//			logger.info("* Message coming from the server: '{}'", responseMessage);
//		}
//	}
//
//	public static void main(String[] args) {
//		if (args.length != 2) {
//			logger.info("Use: java Client.Client [host] [port]");
//			System.exit(0);
//		}
//
//		String hostname = args[0];
//		String port = args[1];
//
//		ExampleClient exampleClient = new ExampleClient(hostname, port);
//		exampleClient.registerUser(USER, PASSWORD);
//		exampleClient.sayMessage(USER, PASSWORD, "This is a test!...");
//	}
}