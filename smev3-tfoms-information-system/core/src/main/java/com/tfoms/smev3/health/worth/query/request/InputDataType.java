//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.22 at 01:34:08 PM KRAT 
//


package com.tfoms.smev3.health.worth.query.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InputDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InputDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InsuredRenderingListRequest" type="{http://ffoms.ru/GetInsuredRenderedMedicalServices/1.0.0}InsuredRenderingListRequestType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputData", namespace = "http://ffoms.ru/GetInsuredRenderedMedicalServices/1.0.0", propOrder = {
    "insuredRenderingListRequest"
})
@XmlRootElement
public class InputDataType {

    @XmlElement(name = "InsuredRenderingListRequest", required = true)
    protected InsuredRenderingListRequestType insuredRenderingListRequest;

    /**
     * Gets the value of the insuredRenderingListRequest property.
     * 
     * @return
     *     possible object is
     *     {@link InsuredRenderingListRequestType }
     *     
     */
    public InsuredRenderingListRequestType getInsuredRenderingListRequest() {
        return insuredRenderingListRequest;
    }

    /**
     * Sets the value of the insuredRenderingListRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link InsuredRenderingListRequestType }
     *     
     */
    public void setInsuredRenderingListRequest(InsuredRenderingListRequestType value) {
        this.insuredRenderingListRequest = value;
    }

}
