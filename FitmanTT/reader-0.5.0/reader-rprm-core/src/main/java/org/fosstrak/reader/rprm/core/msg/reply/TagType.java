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
// Generated on: 2006.07.05 at 05:26:35 PM CEST 
//


package org.fosstrak.reader.rprm.core.msg.reply;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.fosstrak.reader.rprm.core.msg.reply.TagEventType;
import org.fosstrak.reader.rprm.core.msg.reply.TagFieldValueParamType;
import org.fosstrak.reader.rprm.core.msg.reply.TagType;
import org.w3c.dom.Element;


/**
 * tag with associated events
 * 
 * <p>Java class for TagType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TagType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tagID" type="{http://www.w3.org/2001/XMLSchema}hexBinary" minOccurs="0"/>
 *         &lt;element name="tagIDAsPureURI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tagIDAsTagURI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tagType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tagEvent" type="{urn:epcglobal:rp:xsd:1}TagEventType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tagFields" type="{urn:epcglobal:rp:xsd:1}TagFieldValueParamType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;any/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TagType", propOrder = {
    "tagID",
    "tagIDAsPureURI",
    "tagIDAsTagURI",
    "tagType",
    "tagEvent",
    "tagFields",
    "any"
})
public class TagType {

    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] tagID;
    protected String tagIDAsPureURI;
    protected String tagIDAsTagURI;
    protected String tagType;
    protected List<TagEventType> tagEvent;
    protected List<TagFieldValueParamType> tagFields;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the tagID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getTagID() {
        return tagID;
    }

    /**
     * Sets the value of the tagID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTagID(byte[] value) {
        this.tagID = ((byte[]) value);
    }

    /**
     * Gets the value of the tagIDAsPureURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTagIDAsPureURI() {
        return tagIDAsPureURI;
    }

    /**
     * Sets the value of the tagIDAsPureURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTagIDAsPureURI(String value) {
        this.tagIDAsPureURI = value;
    }

    /**
     * Gets the value of the tagIDAsTagURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTagIDAsTagURI() {
        return tagIDAsTagURI;
    }

    /**
     * Sets the value of the tagIDAsTagURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTagIDAsTagURI(String value) {
        this.tagIDAsTagURI = value;
    }

    /**
     * Gets the value of the tagType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTagType() {
        return tagType;
    }

    /**
     * Sets the value of the tagType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTagType(String value) {
        this.tagType = value;
    }

    /**
     * Gets the value of the tagEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tagEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTagEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TagEventType }
     * 
     * 
     */
    public List<TagEventType> getTagEvent() {
        if (tagEvent == null) {
            tagEvent = new ArrayList<TagEventType>();
        }
        return this.tagEvent;
    }

    /**
     * Gets the value of the tagFields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tagFields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTagFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TagFieldValueParamType }
     * 
     * 
     */
    public List<TagFieldValueParamType> getTagFields() {
        if (tagFields == null) {
            tagFields = new ArrayList<TagFieldValueParamType>();
        }
        return this.tagFields;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
