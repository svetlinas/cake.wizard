package bg.cakerecipes.searchservices.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import bg.cakerecipes.searchservices.service.model.Entry;
import bg.cakerecipes.searchservices.service.model.SearchCake;

/**
 * The inteface for the JAX-WS Search Service
 * 
 * @author Leni Kirilov
 * 
 */
@WebService(name = "SearchService", targetNamespace = "http://service.searchservices.cakerecipes.bg/")
public interface SearchService {

	/**
	 * Method for searching through the index tries and expecting ranked object
	 * Ids
	 * 
	 * @param cakes - cakes to be search
	 * @param keyword
	 *            - search keyword
	 * @return Map of objectId, rank for the selected keyword
	 */

	@WebMethod(operationName = "query", action = "urn:Query")
	@RequestWrapper(className = "bg.cakerecipes.searchservices.service.jaxws.Query", localName = "query", targetNamespace = "http://service.searchservices.cakerecipes.bg/")
	@ResponseWrapper(className = "bg.cakerecipes.searchservices.service.jaxws.QueryResponse", localName = "queryResponse", targetNamespace = "http://service.searchservices.cakerecipes.bg/")
	@WebResult(name = "return")
	public List<Entry> query(@WebParam(name = "arg0") List<SearchCake> cakes, @WebParam(name = "arg1") String keyword);
	
}
//	/**
//	 *
//	 * 
//	 * @param cakes
//	 * @param filteringCategory
//	 * @return
//	 */
//	public List<Long> filter(List<SearchCake> cakes, String filteringCategory);
//}
