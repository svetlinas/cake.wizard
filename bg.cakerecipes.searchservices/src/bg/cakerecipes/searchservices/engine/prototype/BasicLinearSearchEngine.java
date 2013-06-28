package bg.cakerecipes.searchservices.engine.prototype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bg.cakerecipes.searchservices.engine.CakeSearchEngine;
import bg.cakerecipes.searchservices.service.model.SearchCake;

/**
 * Provides simple string-matching algorithm for ranking. <br>
 * Rank is calculate by Linear ranking algorithm.
 * 
 * @author Leni Kirilov
 * 
 */
public class BasicLinearSearchEngine implements CakeSearchEngine {

	private static final Long WEIGHT_NAME = 1L;
	private static final Long WEIGHT_RECIPE = 2L;
	private static final Long WEIGHT_CATEGORY = 5L;

	/**
	 * 
	 * @param cakes
	 *           - objects to be ranked
	 * @param query
	 *           - query used for ranking
	 * @return map (id, rank)
	 */
	@Override
	public Map<Long, Long> rankCakes(List<SearchCake> cakes, String query) {
		Map<Long, Long> resultRankMap = new HashMap<Long, Long>(cakes.size());

		for (SearchCake cake : cakes) {
			resultRankMap.put(cake.getId(), calculateRank(cake, query));
		}

		return resultRankMap;
	}

	// TODO write JUnit tests for this Linear ranking algorithm
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
}
