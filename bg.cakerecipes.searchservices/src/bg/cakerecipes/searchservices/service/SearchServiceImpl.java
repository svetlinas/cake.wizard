package bg.cakerecipes.searchservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import bg.cakerecipes.searchservices.engine.prototype.BasicLinearSearchEngine;
import bg.cakerecipes.searchservices.service.model.Entry;
import bg.cakerecipes.searchservices.service.model.SearchCake;

/**
 * Stub implementation of the search service
 * 
 * @author Leni Kirilov
 * 
 */
@WebService(targetNamespace = "http://service.searchservices.cakerecipes.bg/", endpointInterface = "bg.cakerecipes.searchservices.service.SearchService", portName = "SearchServiceImplPort", serviceName = "SearchServiceImplService")
public class SearchServiceImpl implements SearchService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bg.cakerecipes.searchservices.service.SearchService#query(java.util.List,
	 * java.lang.String)
	 */
	public List<Entry> query(List<SearchCake> cakes, String keyword) {
		List<Entry> resultRankMap = new ArrayList<Entry>(cakes.size());
		
		Map<Long, Long> rankedCakesMap = makeBasicRanking(cakes, keyword); 
		
		for(Long id : rankedCakesMap.keySet()){
			Entry e = new Entry();

			e.setId(id);
			e.setRank(rankedCakesMap.get(id));
			
			System.out.println(e.toString());
			
			resultRankMap.add(e);
		}

		return resultRankMap;
	}
	
	private Map<Long, Long> makeBasicRanking(List<SearchCake> cakes, String query){
		//TODO use interface when decide on common stuff
		BasicLinearSearchEngine basicLinearSearchEngine = new BasicLinearSearchEngine();
		return basicLinearSearchEngine.rankCakes(cakes, query);
	}
	
	private Map<Long, Long> makeComplexRanking(List<SearchCake> cakes, String query){
		//TODO use lucene
		return null;
	}
}
