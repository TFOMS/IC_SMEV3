//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.22 at 01:32:40 PM KRAT 
//


package com.tfoms.smev3.egr_zags.adapter.request.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FindTypeCriteria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FindTypeCriteria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="messagePeriodCriteria" type="{urn://x-artefacts-smev-gov-ru/services/service-adapter/types}MessageIntervalCriteria"/>
 *         &lt;element name="messageClientIdCriteria" type="{urn://x-artefacts-smev-gov-ru/services/service-adapter/types}MessageClientIdCriteria"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindTypeCriteria", propOrder = {
    "messagePeriodCriteria",
    "messageClientIdCriteria"
})
public class FindTypeCriteria {

    protected MessageIntervalCriteria messagePeriodCriteria;
    protected MessageClientIdCriteria messageClientIdCriteria;

    /**
     * Gets the value of the messagePeriodCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link MessageIntervalCriteria }
     *     
     */
    public MessageIntervalCriteria getMessagePeriodCriteria() {
        return messagePeriodCriteria;
    }

    /**
     * Sets the value of the messagePeriodCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageIntervalCriteria }
     *     
     */
    public void setMessagePeriodCriteria(MessageIntervalCriteria value) {
        this.messagePeriodCriteria = value;
    }

    /**
     * Gets the value of the messageClientIdCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link MessageClientIdCriteria }
     *     
     */
    public MessageClientIdCriteria getMessageClientIdCriteria() {
        return messageClientIdCriteria;
    }

    /**
     * Sets the value of the messageClientIdCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageClientIdCriteria }
     *     
     */
    public void setMessageClientIdCriteria(MessageClientIdCriteria value) {
        this.messageClientIdCriteria = value;
    }

}
