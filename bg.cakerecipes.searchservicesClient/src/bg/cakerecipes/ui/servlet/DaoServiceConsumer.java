package bg.cakerecipes.ui.servlet;

import java.io.PrintStream;
import java.util.List;

import bg.cakerecipes.client.rest.DAOClient;
import bg.cakerecipes.daoservices.rest.model.Cake;

/**
 * 
 * @author Leni Kirilov
 * 
 */
public class DaoServiceConsumer {

	public void displayAllDbStoreCakes(PrintStream out) {
		out.println("----------displayDaoServiceConsumed-----------<br><br>");

		DAOClient dao = new DAOClient();

		List<Cake> cakes = dao.readCakes();

		for (Cake cake : cakes) {
			out.printf("%s <br>", cake.toString());
		}
	}

	// TODO make parent pom
}
