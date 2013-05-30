package bg.cakerecipes.searchservices.service;

import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "SearchService", targetNamespace = "http://searchservices.cakerecipes.bg/")
public interface SearchService {

	/**
	 * 
	 * 
	 * @param keyword
	 *            - search keyword
	 * @return Map of objectId, rank for the keyword
	 */
	@WebMethod(operationName = "query", action = "urn:Query")
	@RequestWrapper(className = "bg.cakerecipes.searchservices.jaxws.Query", localName = "query", targetNamespace = "http://searchservices.cakerecipes.bg/")
	@ResponseWrapper(className = "bg.cakerecipes.searchservices.jaxws.QueryResponse", localName = "queryResponse", targetNamespace = "http://searchservices.cakerecipes.bg/")
	@WebResult(name = "return")
	Map<String, Long> query(@WebParam(name = "keyword") String keyword);
}
