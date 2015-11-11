/*
 * Copyright (C) 2007 ETH Zurich
 *
 * This file is part of Fosstrak (www.fosstrak.org).
 *
 * Fosstrak is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1, as published by the Free Software Foundation.
 *
 * Fosstrak is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Fosstrak; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA  02110-1301  USA
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b26-ea3 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.07.05 at 05:03:34 PM CEST 
//


package org.fosstrak.reader.rprm.core.msg.command;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;

import org.fosstrak.reader.rprm.core.msg.command.NoParamType;
import org.fosstrak.reader.rprm.core.msg.command.TriggerCommand;
import org.fosstrak.reader.rprm.core.msg.command.TriggerCommand.Create;
import org.w3c.dom.Element;


/**
 * <p>Java class for TriggerCommand complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TriggerCommand">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="create">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="triggerType" type="{urn:epcglobal:rp:xsd:1}TriggerTypeParamType"/>
 *                   &lt;element name="triggerValue" type="{urn:epcglobal:rp:xsd:1}TriggerValueParamType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="getMaxNumberSupported" type="{urn:epcglobal:rp:xsd:1}noParamType"/>
 *         &lt;element name="getName" type="{urn:epcglobal:rp:xsd:1}noParamType"/>
 *         &lt;element name="getType" type="{urn:epcglobal:rp:xsd:1}noParamType"/>
 *         &lt;element name="getValue" type="{urn:epcglobal:rp:xsd:1}noParamType"/>
 *         &lt;element name="fire" type="{urn:epcglobal:rp:xsd:1}noParamType"/>
 *         &lt;any/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TriggerCommand", propOrder = {
    "create",
    "getMaxNumberSupported",
    "getName",
    "getType",
    "getValue",
    "fire",
    "any"
})
public class TriggerCommand {

    protected Create create;
    protected NoParamType getMaxNumberSupported;
    protected NoParamType getName;
    protected NoParamType getType;
    protected NoParamType getValue;
    protected NoParamType fire;
    @XmlAnyElement(lax = true)
    protected Object any;

    /**
     * Gets the value of the create property.
     * 
     * @return
     *     possible object is
     *     {@link Create }
     *     
     */
    public Create getCreate() {
        return create;
    }

    /**
     * Sets the value of the create property.
     * 
     * @param value
     *     allowed object is
     *     {@link Create }
     *     
     */
    public void setCreate(Create value) {
        this.create = value;
    }

    /**
     * Gets the value of the getMaxNumberSupported property.
     * 
     * @return
     *     possible object is
     *     {@link NoParamType }
     *     
     */
    public NoParamType getGetMaxNumberSupported() {
        return getMaxNumberSupported;
    }

    /**
     * Sets the value of the getMaxNumberSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoParamType }
     *     
     */
    public void setGetMaxNumberSupported(NoParamType value) {
        this.getMaxNumberSupported = value;
    }

    /**
     * Gets the value of the getName property.
     * 
     * @return
     *     possible object is
     *     {@link NoParamType }
     *     
     */
    public NoParamType getGetName() {
        return getName;
    }

    /**
     * Sets the value of the getName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoParamType }
     *     
     */
    public void setGetName(NoParamType value) {
        this.getName = value;
    }

    /**
     * Gets the value of the getType property.
     * 
     * @return
     *     possible object is
     *     {@link NoParamType }
     *     
     */
    public NoParamType getGetType() {
        return getType;
    }

    /**
     * Sets the value of the getType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoParamType }
     *     
     */
    public void setGetType(NoParamType value) {
        this.getType = value;
    }

    /**
     * Gets the value of the getValue property.
     * 
     * @return
     *     possible object is
     *     {@link NoParamType }
     *     
     */
    public NoParamType getGetValue() {
        return getValue;
    }

    /**
     * Sets the value of the getValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoParamType }
     *     
     */
    public void setGetValue(NoParamType value) {
        this.getValue = value;
    }

    /**
     * Gets the value of the fire property.
     * 
     * @return
     *     possible object is
     *     {@link NoParamType }
     *     
     */
    public NoParamType getFire() {
        return fire;
    }

    /**
     * Sets the value of the fire property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoParamType }
     *     
     */
    public void setFire(NoParamType value) {
        this.fire = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     {@link Element }
     *     
     */
    public Object getAny() {
        return any;
    }

    /**
     * Sets the value of the any property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     {@link Element }
     *     
     */
    public void setAny(Object value) {
        this.any = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="triggerType" type="{urn:epcglobal:rp:xsd:1}TriggerTypeParamType"/>
     *         &lt;element name="triggerValue" type="{urn:epcglobal:rp:xsd:1}TriggerValueParamType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "triggerType",
        "triggerValue"
    })
    public static class Create {

        protected String name;
        protected String triggerType;
        protected String triggerValue;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the triggerType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTriggerType() {
            return triggerType;
        }

        /**
         * Sets the value of the triggerType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTriggerType(String value) {
            this.triggerType = value;
        }

        /**
         * Gets the value of the triggerValue property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTriggerValue() {
            return triggerValue;
        }

        /**
         * Sets the value of the triggerValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTriggerValue(String value) {
            this.triggerValue = value;
        }

    }

}
