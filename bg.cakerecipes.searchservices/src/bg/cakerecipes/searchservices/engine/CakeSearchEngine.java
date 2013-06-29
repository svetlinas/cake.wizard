package bg.cakerecipes.searchservices.engine;

import java.util.List;
import java.util.Map;

import bg.cakerecipes.searchservices.service.model.SearchCake;

/**
 * Common interface for a CakeSearchEngine
 * 
 * @author Leni Kirilov
 *
 */
public interface CakeSearchEngine {

	public Map<Long, Long> rankCakes(List<SearchCake> cakes, String queryPhrase);
	
	public void initializeSearchAnalizer();
}
