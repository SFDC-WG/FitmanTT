package com.atos.clients;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.map.ObjectMapper;

import com.atos.util.PropertyFileReader;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.websocket.WebSocket;
import com.ning.http.client.websocket.WebSocketByteListener;
import com.ning.http.client.websocket.WebSocketUpgradeHandler;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class SEMClient {
	
	
	public static ClientResponse authorizeFromSEM(String xml) {
		ClientResponse res = null;
		
		try{
			//Get the IP of the SEM server
			PropertyFileReader fr = new PropertyFileReader("event.properties");
			String server = fr.getProperty("ip.sem");
			
			Client client = Client.create();
	 
			WebResource webResource = client
			   .resource("http://" + server + "/semap/sessions");
	 
			ClientResponse response = webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML)
			   .post(ClientResponse.class, xml);
			
			res = response;
			
			
		}catch(Exception e){
			res = null;
		}
		finally{
			return res;
		}
	}
	
	public static ClientResponse openSession(HttpHeaders headers) {
		ClientResponse res = null;
		
		try{
			ClientConfig config = new DefaultClientConfig();
		    Client client = Client.create(config);
		    MultivaluedMap<String, String> multi = headers.getRequestHeaders();
		    List<String> l = multi.get("Location");
		    String location = l.get(0);
		    l = multi.get("X-Sec-Event-Access-MAC");
		    String mac = l.get(0);	
		    l = multi.get("X-Sec-Event-Access-Token");
		    String token = l.get(0);
		    l = multi.get("X-Sec-Event-Access-Digest");
		    String digest = l.get(0);
		    WebResource webResource = client.resource(location);
		    
		    ClientResponse response = webResource
		            .accept(MediaType.APPLICATION_XML)
		            .header("X-Sec-Event-Access-MAC", mac)
		            .header("X-Sec-Event-Access-Token", token)
		            .header("X-Sec-Event-Access-Digest", digest)
		            .get(ClientResponse.class);
			
			res = response;
					
		}catch(Exception e){
			res = null;
		}
		finally{
			return res;
		}
	}
	
	public static String publishWebSocket(HttpHeaders headers) {
		String result="302";
						
		ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    MultivaluedMap<String, String> multi = headers.getRequestHeaders();
	    List<String> l = multi.get("LocationWS");
	    String location = l.get(0);
	    l = multi.get("app-ID");
	    String appID = l.get(0);	
	    l = multi.get("payload");
	    String payload = l.get(0);
	    l = multi.get("pattern");
	    String pattern = l.get(0);
	    
	            
        AsyncHttpClient c = new AsyncHttpClient(); 
        // or new AsyncHttpClient(new GrizzlyAsyncHttpprovider(config))

        try {
        	WebSocket websocket = c.prepareGet(location)
			     .execute(
			       new WebSocketUpgradeHandler.Builder().addWebSocketListener(
			          new WebSocketByteListener() {

			         @Override
			         public void onOpen(WebSocket websocket) {
			        	 if (websocket.isOpen()){
			        		 //System.out.println("Websocket opened");
			        	 }
			         }

			         @Override
			         public void onClose(WebSocket websocket) {
			        	 //System.out.println("Websocket closed");
			         }

			         @Override
			         public void onError(Throwable t) {
			        	 //System.out.println("Websocket error " + t.getMessage());
			         }

			         @Override
			         public void onMessage(byte[] message) {
			         }

			         @Override
			         public void onFragment(byte[] fragment, boolean last) {
			         }
			     })
			     .setProtocol("seap")
			     .build()).get();
        	
        	//If the websocket is opened correctly, we prepare the json message to send 
        	if (websocket.isOpen()){
        		String json = prepareJSONMessage(appID, payload, pattern); 
        		if (json==null){
        			result="500";
        		}else{
        			websocket.sendTextMessage(json);
        			Thread.sleep(6000);
        			websocket.close();
        		}
        	}
        	
		} catch (InterruptedException e) {
			result="500";
			e.printStackTrace();
		} catch (ExecutionException e) {
			result="500";
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			result="500";
		}

        	    
	    return result;   
		       
	}
	
	private static String prepareJSONMessage(String appID, String payload, String pattern){
		String json = null;
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("stringfield", "stringfield");
        result.put("numberfield", "numberfield");
        result.put("content-type", "application/json");
        result.put("content-encoding", "UTF-8");
        result.put("content-type", "application/json");
        result.put("content-transfer-encoding", "string");
        result.put("persistent", "true");
        result.put("app-ID", appID);
        result.put("priority", "10");
        result.put("payload", payload);
        result.put("pattern", pattern);
        ObjectMapper map = new ObjectMapper();
        if (!result.isEmpty()) {
            try {
                json = map.writeValueAsString(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return json;
	}
}
