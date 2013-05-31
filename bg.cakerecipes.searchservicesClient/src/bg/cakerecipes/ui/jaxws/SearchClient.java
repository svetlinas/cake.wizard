package bg.cakerecipes.ui.jaxws;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import bg.cakerecipes.searchservices.service.Entry;
import bg.cakerecipes.searchservices.service.SearchService;
import bg.cakerecipes.searchservices.service.SearchServiceImplService;

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
	public Map<String,Long> query(String keyword){
		List<Entry> entries = port.query(keyword);
		Map<String,Long> rankingMap = new HashMap<String,Long>(entries.size());
		
		for(Entry e : entries){
			rankingMap.put(e.getId(), e.getRank());
		}
		
		return rankingMap;
	}
	
	public void buildIndexTree(List<Object> objects){
		//TODO ?
	}
	
}
