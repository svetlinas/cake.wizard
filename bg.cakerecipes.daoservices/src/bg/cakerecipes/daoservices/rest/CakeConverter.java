package bg.cakerecipes.daoservices.rest;

import java.util.ArrayList;
import java.util.List;

import bg.cakerecipes.daoservices.db.model.IDBCake;
import bg.cakerecipes.daoservices.rest.model.Cake;

/**
 * 
 * Impl class for converting between DBModel to Rest Model of cakes
 * 
 * @author Leni Kirilov
 * 
 */
public class CakeConverter implements ICakeConverter {

	@Override
	public Cake buildCake(IDBCake dbCake) {
		final Cake cake = new Cake();
		cake.setId(dbCake.getId());
		cake.setName(dbCake.getName());
		cake.setIngredients(dbCake.getIngredients());
		cake.setRecipe(dbCake.getRecipe());
		return cake;
	}

	@Override
	public List<Cake> buildCakes(List<IDBCake> dbCakes) {
		final List<Cake> result = new ArrayList<Cake>();
		
		for (IDBCake idbCake : dbCakes) {
			result.add(buildCake(idbCake));
		}
		
		return result;
	}

}