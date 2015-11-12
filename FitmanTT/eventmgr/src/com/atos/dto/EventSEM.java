package com.atos.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Atos
 * 
 * Information for subscribe an event.
 */
public class EventSEM implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String eventMessage;
	private Long eventNumber;
	private String eventContentType;
	private boolean eventPersistent;
	private String eventAppId;
	private int eventPriority;
	private String eventPayload;
	private String eventPattern;
	
	public String getEventMessage() {
		return eventMessage;
	}
	public void setEventMessage(String eventMessage) {
		this.eventMessage = eventMessage;
	}
	public Long getEventNumber() {
		return eventNumber;
	}
	public void setEventNumber(Long eventNumber) {
		this.eventNumber = eventNumber;
	}
	public String getEventContentType() {
		return eventContentType;
	}
	public void setEventContentType(String eventContentType) {
		this.eventContentType = eventContentType;
	}
	public boolean isEventPersistent() {
		return eventPersistent;
	}
	public void setEventPersistent(boolean eventPersistent) {
		this.eventPersistent = eventPersistent;
	}
	public String getEventAppId() {
		return eventAppId;
	}
	public void setEventAppId(String eventAppId) {
		this.eventAppId = eventAppId;
	}
	public int getEventPriority() {
		return eventPriority;
	}
	public void setEventPriority(int eventPriority) {
		this.eventPriority = eventPriority;
	}
	public String getEventPayload() {
		return eventPayload;
	}
	public void setEventPayload(String eventPayload) {
		this.eventPayload = eventPayload;
	}
	public String getEventPattern() {
		return eventPattern;
	}
	public void setEventPattern(String eventPattern) {
		this.eventPattern = eventPattern;
	}
	
}
