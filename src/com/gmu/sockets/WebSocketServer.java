package com.gmu.sockets;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ApplicationScoped
@SuppressWarnings("PMD")
@ServerEndpoint("/actions")
public class WebSocketServer {

	@Inject
	private WebSocketSessionHandler sessionHandler;
	
	 @OnOpen
     public void open(Session session) {
		 sessionHandler.addSession(session);
		 
		 System.out.println(session.getId());
	 }
	
	 @OnClose
	     public void close(Session session) {
		 sessionHandler.removeSession(session);
	 }
	
	 @OnError
	     public void onError(Throwable error) {
		 Logger.getLogger(WebSocketServer.class.getName()).log(Level.SEVERE, null, error);
	 }
	 @OnMessage
     public void handleMessage(String message, Session session) throws ClassNotFoundException, SQLException {
		 try (JsonReader reader = Json.createReader(new StringReader(message))) {
		         JsonObject jsonMessage = reader.readObject();
			 System.out.println(jsonMessage);
			 if(jsonMessage.getString("action").equals("initialization"))
			 {
				 sessionHandler.addUserToGame(jsonMessage,session);
			 }
			 if(jsonMessage.getString("action").equals("bidding"))
			 {
				 sessionHandler.bid(jsonMessage, session);
			 }
			 if(jsonMessage.getString("action").equals("game"))
			 {
				 sessionHandler.game(jsonMessage, session);
			 }
		 }
	 }
}
