package bg.cakerecipes.searchservices.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

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

	private static final Long WEIGHT_NAME = 1L;
	private static final Long WEIGHT_RECIPE = 2L;
	private static final Long WEIGHT_CATEGORY = 5L;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bg.cakerecipes.searchservices.service.SearchService#query(java.util.List,
	 * java.lang.String)
	 */
	public List<Entry> query(List<SearchCake> cakes, String keyword) {
		List<Entry> resultRankMap = new ArrayList<Entry>(cakes.size());
		
		for(SearchCake cake : cakes){
			Entry e = new Entry();

			e.setId(cake.getId());
			e.setRank(calculateRank(cake, keyword));
			
			System.out.printf("cakeName= %s; cakeRank= %d", cake.getName(), e.getRank());
			
			resultRankMap.add(e);
		}

		return resultRankMap;
	}

	private Long calculateRank(SearchCake cake, String keyword) {
		Long rank = 0L;

		if (cake.getName().contains(keyword)) {
			rank += WEIGHT_NAME;
		}

		rank += findRepeatingString(cake.getRecipe(), keyword) * WEIGHT_RECIPE;

		for (String category : cake.getCategories()) {
			if (category.contains(keyword)) {
				rank += WEIGHT_CATEGORY;
			}
		}

		return rank;
	}

	private Long findRepeatingString(String source, String findStr) {
		int lastIndex = 0;
		Long count = 0L;

		while (lastIndex != -1) {

			lastIndex = source.indexOf(findStr, lastIndex);

			if (lastIndex != -1) {
				count++;
				lastIndex += findStr.length();
			}
		}
		return count;
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * bg.cakerecipes.searchservices.service.SearchService#filter(java.util.
//	 * List, java.lang.String)
//	 */
//	@Override
//	public List<Long> filter(List<SearchCake> cakes, String filteringCategory) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
