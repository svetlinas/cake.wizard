package bg.cakerecipes.searchservices.service;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

@WebService(
		targetNamespace = "http://searchservices.cakerecipes.bg/", 
		endpointInterface = "bg.cakerecipes.searchservices.service.SearchService", 
		portName = "SearchServiceImplPort", 
		serviceName = "SearchServiceImplService")
public class SearchServiceImpl implements SearchService {

	public Map<String, Long> query(String keyword) {
		Map<String, Long> rankingMap = new HashMap<String, Long>();

		rankingMap.put("object-id-1", new Long(10));
		return rankingMap;
	}

}
