package bg.cakerecipes.searchservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import bg.cakerecipes.searchservices.engine.CakeSearchEngine;
import bg.cakerecipes.searchservices.engine.lucene.ComplexSearchEngine;
import bg.cakerecipes.searchservices.service.model.Entry;
import bg.cakerecipes.searchservices.service.model.SearchCake;

/**
 * Implementation of the search service by calling external search engines.
 * 
 * @author Leni Kirilov
 * 
 */
@WebService(targetNamespace = "http://service.searchservices.cakerecipes.bg/", endpointInterface = "bg.cakerecipes.searchservices.service.SearchService", portName = "SearchServiceImplPort", serviceName = "SearchServiceImplService")
public class SearchServiceImpl implements SearchService {

//	private CakeSearchEngine searchEngine = new BasicLinearSearchEngine();
	private CakeSearchEngine searchEngine = new ComplexSearchEngine();
	
	@Override
	public List<Entry> query(List<SearchCake> cakes, String keyword) {
		List<Entry> resultRankMap = new ArrayList<Entry>(cakes.size());
		
		Map<Long, Long> rankedCakesMap = searchEngine.rankCakes(cakes, keyword);
		
		for(Long id : rankedCakesMap.keySet()){
			Entry e = new Entry();

			e.setId(id);
			e.setRank(rankedCakesMap.get(id));
			
			System.out.println(e.toString());
			
			resultRankMap.add(e);
		}

		return resultRankMap;
	}
}
