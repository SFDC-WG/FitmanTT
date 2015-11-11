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

import org.fosstrak.reader.rprm.core.msg.command.DataSelectorCommand;
import org.fosstrak.reader.rprm.core.msg.command.EventTypeListParamType;
import org.fosstrak.reader.rprm.core.msg.command.FieldNameListParamType;
import org.fosstrak.reader.rprm.core.msg.command.NoParamType;
import org.fosstrak.reader.rprm.core.msg.command.StringListParamType;
import org.fosstrak.reader.rprm.core.msg.command.DataSelectorCommand.AddEventFilters;
import org.fosstrak.reader.rprm.core.msg.command.DataSelectorCommand.AddFieldNames;
import org.fosstrak.reader.rprm.core.msg.command.DataSelectorCommand.AddTagFieldNames;
import org.fosstrak.reader.rprm.core.msg.command.DataSelectorCommand.Create;
import org.fosstrak.reader.rprm.core.msg.command.DataSelectorCommand.RemoveEventFilters;
import org.fosstrak.reader.rprm.core.msg.command.DataSelectorCommand.RemoveFieldNames;
import org.fosstrak.reader.rprm.core.msg.command.DataSelectorCommand.RemoveTagFieldNames;
import org.w3c.dom.Element;


/**
 * <p>Java class for DataSelectorCommand complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataSelectorCommand">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="create">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="getName" type="{urn:epcglobal:rp:xsd:1}noParamType"/>
 *         &lt;element name="addFieldNames">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fieldNames" type="{urn:epcglobal:rp:xsd:1}FieldNameListParamType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="removeFieldNames">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fieldNames" type="{urn:epcglobal:rp:xsd:1}FieldNameListParamType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="removeAllFieldNames" type="{urn:epcglobal:rp:xsd:1}noParamType"/>
 *         &lt;element name="getAllFieldNames" type="{urn:epcglobal:rp:xsd:1}noParamType"/>
 *         &lt;element name="addEventFilters">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="eventType" type="{urn:epcglobal:rp:xsd:1}EventTypeListParamType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="removeEventFilters">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="eventType" type="{urn:epcglobal:rp:xsd:1}EventTypeListParamType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="removeAllEventFilters" type="{urn:epcglobal:rp:xsd:1}noParamType"/>
 *         &lt;element name="getAllEventFilters" type="{urn:epcglobal:rp:xsd:1}noParamType"/>
 *         &lt;element name="addTagFieldNames">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fieldNames" type="{urn:epcglobal:rp:xsd:1}StringListParamType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="removeTagFieldNames">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fieldNames" type="{urn:epcglobal:rp:xsd:1}StringListParamType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="removeAllTagFieldNames" type="{urn:epcglobal:rp:xsd:1}noParamType"/>
 *         &lt;element name="getAllTagFieldNames" type="{urn:epcglobal:rp:xsd:1}noParamType"/>
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
@XmlType(name = "DataSelectorCommand", propOrder = {
    "create",
    "getName",
    "addFieldNames",
    "removeFieldNames",
    "removeAllFieldNames",
    "getAllFieldNames",
    "addEventFilters",
    "removeEventFilters",
    "removeAllEventFilters",
    "getAllEventFilters",
    "addTagFieldNames",
    "removeTagFieldNames",
    "removeAllTagFieldNames",
    "getAllTagFieldNames",
    "any"
})
public class DataSelectorCommand {

    protected Create create;
    protected NoParamType getName;
    protected AddFieldNames addFieldNames;
    protected RemoveFieldNames removeFieldNames;
    protected NoParamType removeAllFieldNames;
    protected NoParamType getAllFieldNames;
    protected AddEventFilters addEventFilters;
    protected RemoveEventFilters removeEventFilters;
    protected NoParamType removeAllEventFilters;
    protected NoParamType getAllEventFilters;
    protected AddTagFieldNames addTagFieldNames;
    protected RemoveTagFieldNames removeTagFieldNames;
    protected NoParamType removeAllTagFieldNames;
    protected NoParamType getAllTagFieldNames;
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
     * Gets the value of the addFieldNames property.
     * 
     * @return
     *     possible object is
     *     {@link AddFieldNames }
     *     
     */
    public AddFieldNames getAddFieldNames() {
        return addFieldNames;
    }

    /**
     * Sets the value of the addFieldNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddFieldNames }
     *     
     */
    public void setAddFieldNames(AddFieldNames value) {
        this.addFieldNames = value;
    }

    /**
     * Gets the value of the removeFieldNames property.
     * 
     * @return
     *     possible object is
     *     {@link RemoveFieldNames }
     *     
     */
    public RemoveFieldNames getRemoveFieldNames() {
        return removeFieldNames;
    }

    /**
     * Sets the value of the removeFieldNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoveFieldNames }
     *     
     */
    public void setRemoveFieldNames(RemoveFieldNames value) {
        this.removeFieldNames = value;
    }

    /**
     * Gets the value of the removeAllFieldNames property.
     * 
     * @return
     *     possible object is
     *     {@link NoParamType }
     *     
     */
    public NoParamType getRemoveAllFieldNames() {
        return removeAllFieldNames;
    }

    /**
     * Sets the value of the removeAllFieldNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoParamType }
     *     
     */
    public void setRemoveAllFieldNames(NoParamType value) {
        this.removeAllFieldNames = value;
    }

    /**
     * Gets the value of the getAllFieldNames property.
     * 
     * @return
     *     possible object is
     *     {@link NoParamType }
     *     
     */
    public NoParamType getGetAllFieldNames() {
        return getAllFieldNames;
    }

    /**
     * Sets the value of the getAllFieldNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoParamType }
     *     
     */
    public void setGetAllFieldNames(NoParamType value) {
        this.getAllFieldNames = value;
    }

    /**
     * Gets the value of the addEventFilters property.
     * 
     * @return
     *     possible object is
     *     {@link AddEventFilters }
     *     
     */
    public AddEventFilters getAddEventFilters() {
        return addEventFilters;
    }

    /**
     * Sets the value of the addEventFilters property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddEventFilters }
     *     
     */
    public void setAddEventFilters(AddEventFilters value) {
        this.addEventFilters = value;
    }

    /**
     * Gets the value of the removeEventFilters property.
     * 
     * @return
     *     possible object is
     *     {@link RemoveEventFilters }
     *     
     */
    public RemoveEventFilters getRemoveEventFilters() {
        return removeEventFilters;
    }

    /**
     * Sets the value of the removeEventFilters property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoveEventFilters }
     *     
     */
    public void setRemoveEventFilters(RemoveEventFilters value) {
        this.removeEventFilters = value;
    }

    /**
     * Gets the value of the removeAllEventFilters property.
     * 
     * @return
     *     possible object is
     *     {@link NoParamType }
     *     
     */
    public NoParamType getRemoveAllEventFilters() {
        return removeAllEventFilters;
    }

    /**
     * Sets the value of the removeAllEventFilters property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoParamType }
     *     
     */
    public void setRemoveAllEventFilters(NoParamType value) {
        this.removeAllEventFilters = value;
    }

    /**
     * Gets the value of the getAllEventFilters property.
     * 
     * @return
     *     possible object is
     *     {@link NoParamType }
     *     
     */
    public NoParamType getGetAllEventFilters() {
        return getAllEventFilters;
    }

    /**
     * Sets the value of the getAllEventFilters property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoParamType }
     *     
     */
    public void setGetAllEventFilters(NoParamType value) {
        this.getAllEventFilters = value;
    }

    /**
     * Gets the value of the addTagFieldNames property.
     * 
     * @return
     *     possible object is
     *     {@link AddTagFieldNames }
     *     
     */
    public AddTagFieldNames getAddTagFieldNames() {
        return addTagFieldNames;
    }

    /**
     * Sets the value of the addTagFieldNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddTagFieldNames }
     *     
     */
    public void setAddTagFieldNames(AddTagFieldNames value) {
        this.addTagFieldNames = value;
    }

    /**
     * Gets the value of the removeTagFieldNames property.
     * 
     * @return
     *     possible object is
     *     {@link RemoveTagFieldNames }
     *     
     */
    public RemoveTagFieldNames getRemoveTagFieldNames() {
        return removeTagFieldNames;
    }

    /**
     * Sets the value of the removeTagFieldNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoveTagFieldNames }
     *     
     */
    public void setRemoveTagFieldNames(RemoveTagFieldNames value) {
        this.removeTagFieldNames = value;
    }

    /**
     * Gets the value of the removeAllTagFieldNames property.
     * 
     * @return
     *     possible object is
     *     {@link NoParamType }
     *     
     */
    public NoParamType getRemoveAllTagFieldNames() {
        return removeAllTagFieldNames;
    }

    /**
     * Sets the value of the removeAllTagFieldNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoParamType }
     *     
     */
    public void setRemoveAllTagFieldNames(NoParamType value) {
        this.removeAllTagFieldNames = value;
    }

    /**
     * Gets the value of the getAllTagFieldNames property.
     * 
     * @return
     *     possible object is
     *     {@link NoParamType }
     *     
     */
    public NoParamType getGetAllTagFieldNames() {
        return getAllTagFieldNames;
    }

    /**
     * Sets the value of the getAllTagFieldNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoParamType }
     *     
     */
    public void setGetAllTagFieldNames(NoParamType value) {
        this.getAllTagFieldNames = value;
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
     *         &lt;element name="eventType" type="{urn:epcglobal:rp:xsd:1}EventTypeListParamType"/>
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
        "eventType"
    })
    public static class AddEventFilters {

        protected EventTypeListParamType eventType;

        /**
         * Gets the value of the eventType property.
         * 
         * @return
         *     possible object is
         *     {@link EventTypeListParamType }
         *     
         */
        public EventTypeListParamType getEventType() {
            return eventType;
        }

        /**
         * Sets the value of the eventType property.
         * 
         * @param value
         *     allowed object is
         *     {@link EventTypeListParamType }
         *     
         */
        public void setEventType(EventTypeListParamType value) {
            this.eventType = value;
        }

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
     *         &lt;element name="fieldNames" type="{urn:epcglobal:rp:xsd:1}FieldNameListParamType"/>
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
        "fieldNames"
    })
    public static class AddFieldNames {

        protected FieldNameListParamType fieldNames;

        /**
         * Gets the value of the fieldNames property.
         * 
         * @return
         *     possible object is
         *     {@link FieldNameListParamType }
         *     
         */
        public FieldNameListParamType getFieldNames() {
            return fieldNames;
        }

        /**
         * Sets the value of the fieldNames property.
         * 
         * @param value
         *     allowed object is
         *     {@link FieldNameListParamType }
         *     
         */
        public void setFieldNames(FieldNameListParamType value) {
            this.fieldNames = value;
        }

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
     *         &lt;element name="fieldNames" type="{urn:epcglobal:rp:xsd:1}StringListParamType"/>
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
        "fieldNames"
    })
    public static class AddTagFieldNames {

        protected StringListParamType fieldNames;

        /**
         * Gets the value of the fieldNames property.
         * 
         * @return
         *     possible object is
         *     {@link StringListParamType }
         *     
         */
        public StringListParamType getFieldNames() {
            return fieldNames;
        }

        /**
         * Sets the value of the fieldNames property.
         * 
         * @param value
         *     allowed object is
         *     {@link StringListParamType }
         *     
         */
        public void setFieldNames(StringListParamType value) {
            this.fieldNames = value;
        }

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
        "name"
    })
    public static class Create {

        protected String name;

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
     *         &lt;element name="eventType" type="{urn:epcglobal:rp:xsd:1}EventTypeListParamType"/>
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
        "eventType"
    })
    public static class RemoveEventFilters {

        protected EventTypeListParamType eventType;

        /**
         * Gets the value of the eventType property.
         * 
         * @return
         *     possible object is
         *     {@link EventTypeListParamType }
         *     
         */
        public EventTypeListParamType getEventType() {
            return eventType;
        }

        /**
         * Sets the value of the eventType property.
         * 
         * @param value
         *     allowed object is
         *     {@link EventTypeListParamType }
         *     
         */
        public void setEventType(EventTypeListParamType value) {
            this.eventType = value;
        }

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
     *         &lt;element name="fieldNames" type="{urn:epcglobal:rp:xsd:1}FieldNameListParamType"/>
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
        "fieldNames"
    })
    public static class RemoveFieldNames {

        protected FieldNameListParamType fieldNames;

        /**
         * Gets the value of the fieldNames property.
         * 
         * @return
         *     possible object is
         *     {@link FieldNameListParamType }
         *     
         */
        public FieldNameListParamType getFieldNames() {
            return fieldNames;
        }

        /**
         * Sets the value of the fieldNames property.
         * 
         * @param value
         *     allowed object is
         *     {@link FieldNameListParamType }
         *     
         */
        public void setFieldNames(FieldNameListParamType value) {
            this.fieldNames = value;
        }

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
     *         &lt;element name="fieldNames" type="{urn:epcglobal:rp:xsd:1}StringListParamType"/>
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
        "fieldNames"
    })
    public static class RemoveTagFieldNames {

        protected StringListParamType fieldNames;

        /**
         * Gets the value of the fieldNames property.
         * 
         * @return
         *     possible object is
         *     {@link StringListParamType }
         *     
         */
        public StringListParamType getFieldNames() {
            return fieldNames;
        }

        /**
         * Sets the value of the fieldNames property.
         * 
         * @param value
         *     allowed object is
         *     {@link StringListParamType }
         *     
         */
        public void setFieldNames(StringListParamType value) {
            this.fieldNames = value;
        }

    }

}
