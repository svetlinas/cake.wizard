
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package bg.cakerecipes.searchservices.client;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

/**
 * This class was generated by Apache CXF 2.7.5
 * 2013-05-30T18:59:25.711+03:00
 * Generated source version: 2.7.5
 * 
 */
public class SearchServiceClient {

    public static void main(String[] args) throws Exception {
        QName serviceName = new QName("http://searchservices.cakerecipes.bg/", "SearchServiceImplService");
        QName portName = new QName("http://searchservices.cakerecipes.bg/", "SearchServiceImplPort");

        Service service = Service.create(serviceName);
        service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING,
                        "http://localhost:8082/SearchServiceImplPort"); 
        bg.cakerecipes.searchservices.service.SearchService client = service.getPort(portName,  bg.cakerecipes.searchservices.service.SearchService.class);
        Map<String, Long> resultMap = client.query("bla");
        
        System.out.println();
        System.out.println(resultMap.keySet().size());
        
        // Insert code to invoke methods on the client here
    }

}