
package bg.cakerecipes.searchservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.5
 * Thu May 30 18:59:25 EEST 2013
 * Generated source version: 2.7.5
 */

@XmlRootElement(name = "query", namespace = "http://searchservices.cakerecipes.bg/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "query", namespace = "http://searchservices.cakerecipes.bg/")

public class Query {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

}
