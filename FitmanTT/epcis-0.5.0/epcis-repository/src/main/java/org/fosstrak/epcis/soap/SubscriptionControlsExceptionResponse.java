package org.fosstrak.epcis.soap;

import javax.xml.ws.WebFault;

/**
 * This class was generated by Apache CXF (incubator) 2.0.4-incubator Wed Jan 30
 * 15:43:44 CET 2008 Generated source version: 2.0.4-incubator
 */

@WebFault(name = "SubscriptionControlsException", targetNamespace = "urn:epcglobal:epcis-query:xsd:1")
public class SubscriptionControlsExceptionResponse extends Exception {
    public static final long serialVersionUID = 20080130154344L;

    private org.fosstrak.epcis.model.SubscriptionControlsException subscriptionControlsException;

    public SubscriptionControlsExceptionResponse() {
        super();
    }

    public SubscriptionControlsExceptionResponse(String message) {
        super(message);
    }

    public SubscriptionControlsExceptionResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public SubscriptionControlsExceptionResponse(String message,
            org.fosstrak.epcis.model.SubscriptionControlsException subscriptionControlsException) {
        super(message);
        this.subscriptionControlsException = subscriptionControlsException;
    }

    public SubscriptionControlsExceptionResponse(String message,
            org.fosstrak.epcis.model.SubscriptionControlsException subscriptionControlsException, Throwable cause) {
        super(message, cause);
        this.subscriptionControlsException = subscriptionControlsException;
    }

    public org.fosstrak.epcis.model.SubscriptionControlsException getFaultInfo() {
        return this.subscriptionControlsException;
    }
}
