package com.atos.resources;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.atos.clients.SEMClient;
import com.sun.jersey.api.client.ClientResponse;

@Path("/sem")
public class EventResource {
 	
	@POST
	@Path("/authorize")
	@Consumes(MediaType.APPLICATION_XML)
	public Response getAuthorizeInJSON(String authorization) {
		ResponseBuilder r = null;
		String result = "";
		
		if (authorization== null || authorization.trim().equals("")){
			result = "No content";
			r = Response.status(204);
		}else
		{
			//client for retrieve id session from SEM
			ClientResponse res = SEMClient.authorizeFromSEM(authorization);
			
			try{
				if (res==null){
					result = "Service unavailable";
					r = Response.status(503);
				}else{
					Map map = res.getHeaders();
					//Returns url with the sessionID
					result = "return url sessionID from authorization " + authorization;
					r = Response.status(res.getStatus());
					r.header("Location", map.get("Location"));
					r.header("X-Sec-Event-Access-MAC", map.get("X-Sec-Event-Access-MAC"));
					r.header("X-Sec-Event-Access-Token", map.get("X-Sec-Event-Access-Token"));
					r.header("X-Sec-Event-Access-Digest", map.get("X-Sec-Event-Access-Digest"));
				}
			}catch(Exception e){
				result = "Service unavailable";
				r = Response.status(503); 
			}
		}		
		return r.entity(result).build();
 
	}
	
	@GET
	@Path("/session")
	public Response createSessionInJSON(@Context HttpHeaders headers) {
		ResponseBuilder r = null;
		String result = "";
				 
		//client for open session from SEM
		//Returns url with the channelID 
		ClientResponse res = SEMClient.openSession(headers);
		
		try{
			if (res==null){
				result = "Service unavailable";
				r = Response.status(503);
			}else{
				Map map = res.getHeaders();
				//Returns url with the sessionID
				result = "return url channelID from authorization";
				r = Response.status(res.getStatus());
				r.header("LocationWS", map.get("Location"));
				r.header("Expires", map.get("Expires"));
			}
		}catch(Exception e){
			result = "Service unavailable";
			r = Response.status(503); 
		}
		
		return r.entity(result).build();
 
	}
		
	
	
	@GET
	@Path("/publish")
	public Response openWebsocketInJSON(@Context HttpHeaders headers) {
		ResponseBuilder r = null;
		String result = "";
		
		//client for open websocket using channelID
		//Returns status code 
		String status="opened Websocket with channelID = ";
		
		//client for open session from SEM
		//Returns url with the channelID 
		String res = SEMClient.publishWebSocket(headers);
		
		try{
			if (res.equals("302")){
				result = "Message Published";
				r = Response.status(302);
			}else{
				result = "Error to open the Websocket. Unknown protocol or url";
				r = Response.status(500);
			}
		}catch(Exception e){
			result = "Service unavailable";
			r = Response.status(503); 
		}
				
		
		return r.entity(result).build();
 
	}
	
}
