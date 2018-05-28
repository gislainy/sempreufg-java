package br.com.sempreufg.service.websocket;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/clock")
public class WebSocketClock { 
 
  static ScheduledExecutorService timer = 
       Executors.newSingleThreadScheduledExecutor(); 
 
  private static Set<Session> allSessions; 
 
  DateTimeFormatter timeFormatter =  
          DateTimeFormatter.ofPattern("HH:mm:ss");
  @OnOpen  
  public void showTime(Session session){
      allSessions = session.getOpenSessions();
  
      if (allSessions.size()==1){   
        //timer.scheduleAtFixedRate(() -> sendTimeToAll(session),0,1,TimeUnit.SECONDS);    
    	 sendTimeToAll(session);
      }
     }      
 
   private void sendTimeToAll(Session session){       
     allSessions = session.getOpenSessions();
     for (Session sess: allSessions){          
        try{   
          sess.getBasicRemote().sendText("INSERIU ANUNCIO");
          } catch (IOException ioe) {        
              System.out.println(ioe.getMessage());         
          }   
     }   
  }
}
