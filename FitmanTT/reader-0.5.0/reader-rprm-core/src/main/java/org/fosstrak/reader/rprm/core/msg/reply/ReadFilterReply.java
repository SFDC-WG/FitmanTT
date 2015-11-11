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
// 	Generated on: 2005.12.06 um 10:39:40 CET 
//


package org.fosstrak.reader.rprm.core.msg.reply;


/**
 * Java content class for ReadFilterReply complex type.
 * 	<p>The following schema fragment specifies the expected 	content contained within this java content object. 	(defined at file:/C:/Documents%20and%20Settings/fuerera/workspace/JAXP_epc/RpReply.xsd line 984)
 * <p>
 * <pre>
 * &lt;complexType name="ReadFilterReply">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="create">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="returnValue" type="{urn:epcglobal:rp:xsd:1}FilterParamType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="getMaxNumberSupported">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="returnValue" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="getValue">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="returnValue" type="{urn:epcglobal:rp:xsd:1}HexStringType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="getMask">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="returnValue" type="{urn:epcglobal:rp:xsd:1}HexStringType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="getInclusiveFlag">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="returnValue" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface ReadFilterReply {


    /**
     * reply for create Read filter
     * 
     * @return
     *     possible object is
     *     {@link org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.CreateType}
     */
    org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.CreateType getCreate();

    /**
     * reply for create Read filter
     * 
     * @param value
     *     allowed object is
     *     {@link org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.CreateType}
     */
    void setCreate(org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.CreateType value);

    /**
     * reply for get Read filter value
     * 
     * @return
     *     possible object is
     *     {@link org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetValueType}
     */
    org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetValueType getGetValue();

    /**
     * reply for get Read filter value
     * 
     * @param value
     *     allowed object is
     *     {@link org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetValueType}
     */
    void setGetValue(org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetValueType value);

    /**
     * reply for get max supported Read filters
     * 
     * @return
     *     possible object is
     *     {@link org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetMaxNumberSupportedType}
     */
    org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetMaxNumberSupportedType getGetMaxNumberSupported();

    /**
     * reply for get max supported Read filters
     * 
     * @param value
     *     allowed object is
     *     {@link org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetMaxNumberSupportedType}
     */
    void setGetMaxNumberSupported(org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetMaxNumberSupportedType value);

    /**
     * reply for get Inclusive flag
     * 
     * @return
     *     possible object is
     *     {@link org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetInclusiveFlagType}
     */
    org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetInclusiveFlagType getGetInclusiveFlag();

    /**
     * reply for get Inclusive flag
     * 
     * @param value
     *     allowed object is
     *     {@link org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetInclusiveFlagType}
     */
    void setGetInclusiveFlag(org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetInclusiveFlagType value);

    /**
     * reply for get Read filter mask
     * 
     * @return
     *     possible object is
     *     {@link org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetMaskType}
     */
    org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetMaskType getGetMask();

    /**
     * reply for get Read filter mask
     * 
     * @param value
     *     allowed object is
     *     {@link org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetMaskType}
     */
    void setGetMask(org.fosstrak.reader.rprm.core.msg.reply.ReadFilterReply.GetMaskType value);


    /**
     * Java content class for anonymous complex type.
     * 	<p>The following schema fragment specifies the expected 	content contained within this java content object. 	(defined at file:/C:/Documents%20and%20Settings/fuerera/workspace/JAXP_epc/RpReply.xsd line 993)
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="returnValue" type="{urn:epcglobal:rp:xsd:1}FilterParamType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     */
    public interface CreateType {


        /**
         * created Read filter
         * 
         * @return
         *     possible object is
         *     {@link java.lang.String}
         */
        java.lang.String getReturnValue();

        /**
         * created Read filter
         * 
         * @param value
         *     allowed object is
         *     {@link java.lang.String}
         */
        void setReturnValue(java.lang.String value);

    }


    /**
     * Java content class for anonymous complex type.
     * 	<p>The following schema fragment specifies the expected 	content contained within this java content object. 	(defined at file:/C:/Documents%20and%20Settings/fuerera/workspace/JAXP_epc/RpReply.xsd line 1049)
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="returnValue" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     */
    public interface GetInclusiveFlagType {


        /**
         * whether the filter is inclusive filter
         * 
         */
        boolean isReturnValue();

        /**
         * whether the filter is inclusive filter
         * 
         */
        void setReturnValue(boolean value);

    }


    /**
     * Java content class for anonymous complex type.
     * 	<p>The following schema fragment specifies the expected 	content contained within this java content object. 	(defined at file:/C:/Documents%20and%20Settings/fuerera/workspace/JAXP_epc/RpReply.xsd line 1035)
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="returnValue" type="{urn:epcglobal:rp:xsd:1}HexStringType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     */
    public interface GetMaskType {


        /**
         * Read filter mask
         * 
         * @return
         *     possible object is
         *     byte[]
         */
        byte[] getReturnValue();

        /**
         * Read filter mask
         * 
         * @param value
         *     allowed object is
         *     byte[]
         */
        void setReturnValue(byte[] value);

    }


    /**
     * Java content class for anonymous complex type.
     * 	<p>The following schema fragment specifies the expected 	content contained within this java content object. 	(defined at file:/C:/Documents%20and%20Settings/fuerera/workspace/JAXP_epc/RpReply.xsd line 1007)
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="returnValue" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     */
    public interface GetMaxNumberSupportedType {


        /**
         * maximum supported Read filters
         * 
         */
        int getReturnValue();

        /**
         * maximum supported Read filters
         * 
         */
        void setReturnValue(int value);

    }


    /**
     * Java content class for anonymous complex type.
     * 	<p>The following schema fragment specifies the expected 	content contained within this java content object. 	(defined at file:/C:/Documents%20and%20Settings/fuerera/workspace/JAXP_epc/RpReply.xsd line 1021)
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="returnValue" type="{urn:epcglobal:rp:xsd:1}HexStringType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     */
    public interface GetValueType {


        /**
         * Read filter value
         * 
         * @return
         *     possible object is
         *     byte[]
         */
        byte[] getReturnValue();

        /**
         * Read filter value
         * 
         * @param value
         *     allowed object is
         *     byte[]
         */
        void setReturnValue(byte[] value);

    }

}
