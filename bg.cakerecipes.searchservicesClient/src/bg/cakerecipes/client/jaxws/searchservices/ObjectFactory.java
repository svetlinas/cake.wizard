
package bg.cakerecipes.client.jaxws.searchservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bg.cakerecipes.client.jaxws.searchservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _QueryResponse_QNAME = new QName("http://service.searchservices.cakerecipes.bg/", "queryResponse");
    private final static QName _BuildIndexTreeResponse_QNAME = new QName("http://service.searchservices.cakerecipes.bg/", "buildIndexTreeResponse");
    private final static QName _Query_QNAME = new QName("http://service.searchservices.cakerecipes.bg/", "query");
    private final static QName _BuildIndexTree_QNAME = new QName("http://service.searchservices.cakerecipes.bg/", "buildIndexTree");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bg.cakerecipes.client.jaxws.searchservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BuildIndexTree }
     * 
     */
    public BuildIndexTree createBuildIndexTree() {
        return new BuildIndexTree();
    }

    /**
     * Create an instance of {@link BuildIndexTreeResponse }
     * 
     */
    public BuildIndexTreeResponse createBuildIndexTreeResponse() {
        return new BuildIndexTreeResponse();
    }

    /**
     * Create an instance of {@link Query }
     * 
     */
    public Query createQuery() {
        return new Query();
    }

    /**
     * Create an instance of {@link QueryResponse }
     * 
     */
    public QueryResponse createQueryResponse() {
        return new QueryResponse();
    }

    /**
     * Create an instance of {@link Entry }
     * 
     */
    public Entry createEntry() {
        return new Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.searchservices.cakerecipes.bg/", name = "queryResponse")
    public JAXBElement<QueryResponse> createQueryResponse(QueryResponse value) {
        return new JAXBElement<QueryResponse>(_QueryResponse_QNAME, QueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuildIndexTreeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.searchservices.cakerecipes.bg/", name = "buildIndexTreeResponse")
    public JAXBElement<BuildIndexTreeResponse> createBuildIndexTreeResponse(BuildIndexTreeResponse value) {
        return new JAXBElement<BuildIndexTreeResponse>(_BuildIndexTreeResponse_QNAME, BuildIndexTreeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Query }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.searchservices.cakerecipes.bg/", name = "query")
    public JAXBElement<Query> createQuery(Query value) {
        return new JAXBElement<Query>(_Query_QNAME, Query.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuildIndexTree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.searchservices.cakerecipes.bg/", name = "buildIndexTree")
    public JAXBElement<BuildIndexTree> createBuildIndexTree(BuildIndexTree value) {
        return new JAXBElement<BuildIndexTree>(_BuildIndexTree_QNAME, BuildIndexTree.class, null, value);
    }

}
