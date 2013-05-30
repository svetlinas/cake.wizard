
package bg.cakerecipes.searchservices.service;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for entry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="entry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rank" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entry", propOrder = {
    "id",
    "rank"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comment = "JAXB RI v2.2.6")
public class Entry {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comment = "JAXB RI v2.2.6")
    protected String id;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comment = "JAXB RI v2.2.6")
    protected Long rank;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comment = "JAXB RI v2.2.6")
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comment = "JAXB RI v2.2.6")
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the rank property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comment = "JAXB RI v2.2.6")
    public Long getRank() {
        return rank;
    }

    /**
     * Sets the value of the rank property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comment = "JAXB RI v2.2.6")
    public void setRank(Long value) {
        this.rank = value;
    }

}
