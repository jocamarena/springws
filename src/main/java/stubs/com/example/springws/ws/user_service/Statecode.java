//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.12 at 06:51:44 PM PDT 
//


package stubs.com.example.springws.ws.user_service;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statecode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="statecode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CA"/&gt;
 *     &lt;enumeration value="MD"/&gt;
 *     &lt;enumeration value="TX"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "statecode")
@XmlEnum
public enum Statecode {

    CA,
    MD,
    TX;

    public String value() {
        return name();
    }

    public static Statecode fromValue(String v) {
        return valueOf(v);
    }

}