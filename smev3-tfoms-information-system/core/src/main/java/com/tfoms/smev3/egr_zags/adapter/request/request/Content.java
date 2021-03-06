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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Content complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Content">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/service-adapter/types}MessagePrimaryContent"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/service-adapter/types}PersonalSignature" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/service-adapter/types}AttachmentHeaderList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content", propOrder = {
    "messagePrimaryContent",
    "personalSignature",
    "attachmentHeaderList"
})
public class Content {

    @XmlElement(name = "MessagePrimaryContent", required = true)
    protected MessagePrimaryContent messagePrimaryContent;
    @XmlElement(name = "PersonalSignature")
    protected XMLDSigSignatureType personalSignature;
    @XmlElement(name = "AttachmentHeaderList")
    protected AttachmentHeaderList attachmentHeaderList;

    /**
     * Gets the value of the messagePrimaryContent property.
     * 
     * @return
     *     possible object is
     *     {@link MessagePrimaryContent }
     *     
     */
    public MessagePrimaryContent getMessagePrimaryContent() {
        return messagePrimaryContent;
    }

    /**
     * Sets the value of the messagePrimaryContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessagePrimaryContent }
     *     
     */
    public void setMessagePrimaryContent(MessagePrimaryContent value) {
        this.messagePrimaryContent = value;
    }

    /**
     * Gets the value of the personalSignature property.
     * 
     * @return
     *     possible object is
     *     {@link XMLDSigSignatureType }
     *     
     */
    public XMLDSigSignatureType getPersonalSignature() {
        return personalSignature;
    }

    /**
     * Sets the value of the personalSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLDSigSignatureType }
     *     
     */
    public void setPersonalSignature(XMLDSigSignatureType value) {
        this.personalSignature = value;
    }

    /**
     * Gets the value of the attachmentHeaderList property.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentHeaderList }
     *     
     */
    public AttachmentHeaderList getAttachmentHeaderList() {
        return attachmentHeaderList;
    }

    /**
     * Sets the value of the attachmentHeaderList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentHeaderList }
     *     
     */
    public void setAttachmentHeaderList(AttachmentHeaderList value) {
        this.attachmentHeaderList = value;
    }

}
