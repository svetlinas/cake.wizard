package bg.cakerecipes.searchservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.5
 * 2013-05-30T19:03:47.279+03:00
 * Generated source version: 2.7.5
 * 
 */
@WebServiceClient(name = "SearchServiceImplService", 
                  wsdlLocation = "http://localhost:8080/bg.cakerecipes.searchservice/services/SearchServiceImplPort?wsdl",
                  targetNamespace = "http://searchservices.cakerecipes.bg/") 
public class SearchServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://searchservices.cakerecipes.bg/", "SearchServiceImplService");
    public final static QName SearchServiceImplPort = new QName("http://searchservices.cakerecipes.bg/", "SearchServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/bg.cakerecipes.searchservice/services/SearchServiceImplPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SearchServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/bg.cakerecipes.searchservice/services/SearchServiceImplPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SearchServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SearchServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SearchServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public SearchServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public SearchServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public SearchServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns SearchService
     */
    @WebEndpoint(name = "SearchServiceImplPort")
    public SearchService getSearchServiceImplPort() {
        return super.getPort(SearchServiceImplPort, SearchService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SearchService
     */
    @WebEndpoint(name = "SearchServiceImplPort")
    public SearchService getSearchServiceImplPort(WebServiceFeature... features) {
        return super.getPort(SearchServiceImplPort, SearchService.class, features);
    }

}
