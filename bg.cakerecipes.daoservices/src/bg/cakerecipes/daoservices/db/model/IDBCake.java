package bg.cakerecipes.daoservices.db.model;

import java.util.List;

public interface IDBCake {

	public Long getId();

	public String getName();

	public String getIngredients();

	public String getRecipe();

	public String getImageUrl();
	
	public List<String> getCategories();

}
