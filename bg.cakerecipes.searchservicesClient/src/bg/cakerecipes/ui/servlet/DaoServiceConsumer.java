package bg.cakerecipes.ui.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import bg.cakerecipes.client.rest.DAOClient;
import bg.cakerecipes.daoservices.rest.model.Cake;
import bg.cakerecipes.drservices.dr.model.RetrievedCake;
import bg.cakerecipes.externalservices.model.ExternalCake;

/**
 * 
 * @author Leni Kirilov
 * 
 */
public class DaoServiceConsumer {

	public void displayAllDbStoreCakes(PrintStream out) {
		out.println("<br><br>----------displayDaoServiceConsumed-----------<br><br>");

		List<Cake> cakes = getDBCakes();
		for (Cake cake : cakes) {
			out.printf("%s <br>", cake.toString());
		}
	}

	public boolean writeDrCake2Dao(RetrievedCake retrievedCake) {
		final Cake cake = new Cake();

		cake.setName(retrievedCake.getName());
		cake.setRecipe(retrievedCake.getRecipe());
		cake.setImageUrl(retrievedCake.getImageUrl());
		cake.setCategories(retrievedCake.getCategories());

		return new DAOClient().writeCake(cake);
	}

	public boolean writeExternalCake2Dao(ExternalCake externalCake) {
		final Cake cake = new Cake();

		cake.setName(externalCake.getName());
		cake.setRecipe(externalCake.getRecipe());
		cake.setImageUrl(externalCake.getImageUrl());
		cake.setCategories(new ArrayList<String>());

		return new DAOClient().writeCake(cake);
	}
	
	public List<Cake> getDBCakes(){
		return new DAOClient().readCakes();
	}
	
	// TODO make parent pom
}
