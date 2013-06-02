/**
 * 
 */
package bg.cakerecipes.client.jaxws;

import java.util.ArrayList;
import java.util.List;

import bg.cakerecipes.client.jaxws.searchSrv.SearchCake;
import bg.cakerecipes.daoservices.rest.model.Cake;

/**
 * @author Leni Kirilov
 * 
 */
public class SearchCakeConverter {

	public static List<SearchCake> convertToSearchCakes(List<Cake> dbCakes) {

		List<SearchCake> searchModelCakes = new ArrayList<SearchCake>(dbCakes.size());

		for (Cake dbCake : dbCakes) {
			SearchCake searchCake = new SearchCake();

			searchCake.setId(dbCake.getId());
			searchCake.setName(dbCake.getName());
			searchCake.setRecipe(dbCake.getRecipe());

			searchCake.setCategories(dbCake.getCategories());

			searchModelCakes.add(searchCake);
		}

		return searchModelCakes;
	}
}
