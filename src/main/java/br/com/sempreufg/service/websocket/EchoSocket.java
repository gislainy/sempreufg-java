package br.com.sempreufg.service.websocket;

import java.io.IOException;
import java.util.Set;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoSocket {

	private static Set<Session> allSessions;

	@OnMessage
	public String echo(String message, Session client) {
		sendTimeToAll(client);
		return message + " (from your server)";
	}

	private void sendTimeToAll(Session session) {
		allSessions = session.getOpenSessions();
		System.out.println("NÚMERO DE SESSÕES: " + allSessions);
		for (Session sess : allSessions) {
			try {
				sess.getBasicRemote().sendText("INSERIU ANUNCIO");
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
	}

}