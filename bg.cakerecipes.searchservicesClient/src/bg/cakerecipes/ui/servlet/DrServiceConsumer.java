package bg.cakerecipes.ui.servlet;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import bg.cakerecipes.client.rest.DRClient;
import bg.cakerecipes.drservices.dr.model.RetrievedCake;

public class DrServiceConsumer {
	public void displayDataRetrievalServiceConsumed(PrintStream out) {
		out.println("----------displayDataRetrievalServiceConsumed-----------<br><br>");

		List<RetrievedCake> cakes = new DRClient().readData();

		for (RetrievedCake cake : cakes) {
			out.printf("name=%s; price=%f ; categories= <%s> <br>", cake.getName(),
					cake.getPrice(), Arrays.deepToString(cake.getCategories().toArray()));
		}
	}
}
