package bg.cakerecipes.ui.servlet;

import java.io.PrintStream;
import java.util.List;

import bg.cakerecipes.client.rest.DAOClient;
import bg.cakerecipes.daoservices.rest.model.Cake;
import bg.cakerecipes.drservices.dr.model.RetrievedCake;

/**
 * 
 * @author Leni Kirilov
 * 
 */
public class DaoServiceConsumer {
	
	public void displayAllDbStoreCakes(PrintStream out) {
		out.println("<br><br>----------displayDaoServiceConsumed-----------<br><br>");

		List<Cake> cakes = new DAOClient().readCakes();

		for (Cake cake : cakes) {
			out.printf("%s <br>", cake.toString());
		}
	}

	public boolean writeDrCake2Dao(RetrievedCake retrievedCake){
		
		final Cake cake = new Cake();
		
		cake.setName(retrievedCake.getName());
		cake.setRecipe(retrievedCake.getRecipe());
		cake.setImageUrl(retrievedCake.getImageUrl());
		cake.setCategories(retrievedCake.getCategories());
		
		return new DAOClient().writeCake(cake);
	}
	
	// TODO make parent pom
}
