//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.22 at 01:32:40 PM KRAT 
//


package com.tfoms.smev3.egr_zags.adapter.request.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatusMessageCategory.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatusMessageCategory">
 *   &lt;restriction base="{urn://x-artefacts-smev-gov-ru/services/service-adapter/types}string-50">
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StatusMessageCategory")
@XmlEnum
public enum StatusMessageCategory {


    /**
     * 
     *                     
     * 
     */
    OTHER,

    /**
     * 
     *                     
     * 
     */
    ERROR;

    public String value() {
        return name();
    }

    public static StatusMessageCategory fromValue(String v) {
        return valueOf(v);
    }

}
