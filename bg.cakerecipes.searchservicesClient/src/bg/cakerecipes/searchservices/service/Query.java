
package bg.cakerecipes.searchservices.service;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for query complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="query">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "query", propOrder = {
    "arg0"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comments = "JAXB RI v2.2.6")
public class Query {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comments = "JAXB RI v2.2.6")
    protected String arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comments = "JAXB RI v2.2.6")
    public String getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comments = "JAXB RI v2.2.6")
    public void setArg0(String value) {
        this.arg0 = value;
    }

}