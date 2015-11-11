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
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.5-b16-fcs 
// 	See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 	Any modifications to this file will be lost upon recompilation of the source schema. 
// 	Generated on: 2005.12.09 um 11:33:06 CET 
//


package org.fosstrak.reader.rprm.core.msg.reply;


/**
 * Time format
 * Java content class for TimeType complex type.
 * 	<p>The following schema fragment specifies the expected 	content contained within this java content object. 	(defined at file:/C:/Documents%20and%20Settings/fuerera/workspace/JAXP_epc/RpCommon.xsd line 475)
 * <p>
 * <pre>
 * &lt;complexType name="TimeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="timeTick" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeUTC" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface TimeType {


    /**
     * UTC time
     * 
     * @return
     *     possible object is
     *     {@link java.util.Calendar}
     */
    java.util.Calendar getTimeUTC();

    /**
     * UTC time
     * 
     * @param value
     *     allowed object is
     *     {@link java.util.Calendar}
     */
    void setTimeUTC(java.util.Calendar value);

    /**
     * time in ticks
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getTimeTick();

    /**
     * time in ticks
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setTimeTick(java.lang.String value);

}
