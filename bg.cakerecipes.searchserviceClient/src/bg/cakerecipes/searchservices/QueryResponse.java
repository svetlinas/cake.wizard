
package bg.cakerecipes.searchservices;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for queryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_return">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryResponse", propOrder = {
    "_return"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
public class QueryResponse {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
    protected QueryResponse.Return _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link QueryResponse.Return }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
    public synchronized QueryResponse.Return getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryResponse.Return }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
    public synchronized void setReturn(QueryResponse.Return value) {
        this._return = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
    public synchronized String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.MULTI_LINE_STYLE);
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
    public static class Return {

        @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
        protected List<QueryResponse.Return.Entry> entry;

        /**
         * Gets the value of the entry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link QueryResponse.Return.Entry }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
        public synchronized List<QueryResponse.Return.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<QueryResponse.Return.Entry>();
            }
            return this.entry;
        }

        /**
         * Generates a String representation of the contents of this type.
         * This is an extension method, produced by the 'ts' xjc plugin
         * 
         */
        @Override
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
        public synchronized String toString() {
            return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.MULTI_LINE_STYLE);
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
        public static class Entry {

            @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
            protected String key;
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
            protected Long value;

            /**
             * Gets the value of the key property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
            public synchronized String getKey() {
                return key;
            }

            /**
             * Sets the value of the key property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
            public synchronized void setKey(String value) {
                this.key = value;
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
            public synchronized Long getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
            public synchronized void setValue(Long value) {
                this.value = value;
            }

            /**
             * Generates a String representation of the contents of this type.
             * This is an extension method, produced by the 'ts' xjc plugin
             * 
             */
            @Override
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-05-30T07:03:47+03:00", comments = "JAXB RI v2.2.6")
            public synchronized String toString() {
                return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.MULTI_LINE_STYLE);
            }

        }

    }

}
