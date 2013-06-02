package bg.cakerecipes.searchservices.service;

import java.util.List;

/**
 * The inteface for the JAX-WS Search Service
 * 
 * @author Leni Kirilov
 * 
 */
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

	public List<Entry> query(List<SearchCake> cakes, String keyword);
	
//	/**
//	 *
//	 * 
//	 * @param cakes
//	 * @param filteringCategory
//	 * @return
//	 */
//	public List<Long> filter(List<SearchCake> cakes, String filteringCategory);
}
