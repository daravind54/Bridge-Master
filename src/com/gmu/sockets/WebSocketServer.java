package com.gmu.sockets;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ApplicationScoped
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
     public void handleMessage(String message, Session session) {
		 System.out.println(message);
		 sessionHandler.addUserToGame(message,session);
	 }
}
