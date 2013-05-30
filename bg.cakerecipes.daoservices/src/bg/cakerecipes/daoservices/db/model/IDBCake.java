package bg.cakerecipes.daoservices.db.model;

//TODO move to separate package *.api or *.impl for example
public interface IDBCake {

	public Long getId();
	
	public String getName();
	
	public String getIngredients();
	
	public String getRecipe();
	
}
