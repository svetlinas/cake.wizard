
package bg.cakerecipes.searchservices.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buildIndexTree complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buildIndexTree">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buildIndexTree", propOrder = {
    "arg0"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comment = "JAXB RI v2.2.6")
public class BuildIndexTree {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comment = "JAXB RI v2.2.6")
    protected List<Object> arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg0 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg0().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-31T12:05:50+03:00", comment = "JAXB RI v2.2.6")
    public List<Object> getArg0() {
        if (arg0 == null) {
            arg0 = new ArrayList<Object>();
        }
        return this.arg0;
    }

}
