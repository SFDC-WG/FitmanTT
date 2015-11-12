package com.atos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

public class EventManagerSFDC implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageBody;	//Contains XML with the Event from the tags
	private String nameSpace;	//nameSpace of the ShopFloor
	private String dateTime;		//Date & Time of the generation
	private String idMessage;	//Identifier of the event or message 
	private String sessionID;	//Identifier of SEM session
	private String channelID; 	//Identifier of Websocket session
	private String MAC;			//MAC Header
	private String Token;		//Token Header
	private String Digest;		//Token Digest
	
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public String getNameSpace() {
		return nameSpace;
	}
	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getChannelID() {
		return channelID;
	}
	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}
	public String getMAC() {
		return MAC;
	}
	public void setMAC(String mAC) {
		MAC = mAC;
	}
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	public String getDigest() {
		return Digest;
	}
	public void setDigest(String digest) {
		Digest = digest;
	}
	
}
