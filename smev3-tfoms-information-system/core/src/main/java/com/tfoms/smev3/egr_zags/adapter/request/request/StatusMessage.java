//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.22 at 01:32:40 PM KRAT 
//


package com.tfoms.smev3.egr_zags.adapter.request.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for StatusMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusMessage">
 *   &lt;complexContent>
 *     &lt;extension base="{urn://x-artefacts-smev-gov-ru/services/service-adapter/types}Message">
 *       &lt;sequence>
 *         &lt;element name="statusMetadata" type="{urn://x-artefacts-smev-gov-ru/services/service-adapter/types}StatusMetadataType"/>
 *         &lt;element name="status" type="{urn://x-artefacts-smev-gov-ru/services/service-adapter/types}StatusMessageCategory"/>
 *         &lt;element name="details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusMessage", propOrder = {
    "statusMetadata",
    "status",
    "details",
    "timestamp"
})
@XmlSeeAlso({
    ErrorMessage.class
})
public class StatusMessage
    extends Message
{

    @XmlElement(required = true)
    protected StatusMetadataType statusMetadata;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected StatusMessageCategory status;
    protected String details;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;

    /**
     * Gets the value of the statusMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link StatusMetadataType }
     *     
     */
    public StatusMetadataType getStatusMetadata() {
        return statusMetadata;
    }

    /**
     * Sets the value of the statusMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusMetadataType }
     *     
     */
    public void setStatusMetadata(StatusMetadataType value) {
        this.statusMetadata = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusMessageCategory }
     *     
     */
    public StatusMessageCategory getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusMessageCategory }
     *     
     */
    public void setStatus(StatusMessageCategory value) {
        this.status = value;
    }

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetails(String value) {
        this.details = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

}
