package bg.cakerecipes.client.jaxws;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import bg.cakerecipes.client.jaxws.searchSrv.Entry;
import bg.cakerecipes.client.jaxws.searchSrv.SearchCake;
import bg.cakerecipes.client.jaxws.searchSrv.SearchService;
import bg.cakerecipes.client.jaxws.searchSrv.SearchServiceImplService;

/**
 * 
 * @author Leni Kirilov
 *
 */
public class SearchClient {
	
	private SearchService port;

	public SearchClient(){
		QName SERVICE_NAME = new QName("http://service.searchservices.cakerecipes.bg/", "SearchServiceImplService");
		URL wsdlURL = SearchServiceImplService.WSDL_LOCATION;

		SearchServiceImplService ss = new SearchServiceImplService(wsdlURL, SERVICE_NAME);
		this.port = ss.getSearchServiceImplPort();
	}
	
	/**
	 *  Query the search service. It converts the List<Entry> into Map of (objectid, rank)
	 * 
	 * @param keyword
	 * @return
	 */
	public Map<Long,Long> query(List<SearchCake>cakes, String keyword){
		List<Entry> entries = port.query(cakes, keyword);
		Map<Long,Long> rankingMap = new HashMap<Long,Long>(entries.size());
		
		for(Entry e : entries){
			rankingMap.put(e.getId(), e.getRank());
		}
		
		return rankingMap;
	}
}
