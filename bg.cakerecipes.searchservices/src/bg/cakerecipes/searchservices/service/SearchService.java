package bg.cakerecipes.searchservices.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

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
	 * @param keyword
	 *            - search keyword
	 * @return Map of objectId, rank for the selected keyword
	 */
	@WebMethod(operationName = "query", action = "urn:Query")
	@RequestWrapper(className = "bg.cakerecipes.searchservices.service.jaxws.Query", localName = "query", targetNamespace = "http://service.searchservices.cakerecipes.bg/")
	@ResponseWrapper(className = "bg.cakerecipes.searchservices.service.jaxws.QueryResponse", localName = "queryResponse", targetNamespace = "http://service.searchservices.cakerecipes.bg/")
	@WebResult(name = "return")
	public List<Entry> query(@WebParam(name = "arg0") String keyword);

	/**
	 * Builds various indexTrees for these objects
	 * 
	 * @param objects
	 *            - passing list of cakes to be made an Index tree and saved
	 *            into DB
	 */
	@WebMethod(operationName = "buildIndexTree", action = "urn:BuildIndexTree")
	@RequestWrapper(className = "bg.cakerecipes.searchservices.service.jaxws.BuildIndexTree", localName = "buildIndexTree", targetNamespace = "http://service.searchservices.cakerecipes.bg/")
	@ResponseWrapper(className = "bg.cakerecipes.searchservices.service.jaxws.BuildIndexTreeResponse", localName = "buildIndexTreeResponse", targetNamespace = "http://service.searchservices.cakerecipes.bg/")
	@WebResult(name = "return")
	public void buildIndexTree(@WebParam(name = "arg0") List<Object> objects);
	
	//TODO make this list of Cakes which contain or without parameters (gets them from DB itself
}
