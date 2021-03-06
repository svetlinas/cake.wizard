package bg.cakerecipes.ui.servlet.consumers;

import java.io.PrintStream;
import java.util.List;

import bg.cakerecipes.client.rest.DRClient;
import bg.cakerecipes.drservices.dr.model.RetrievedCake;

/**
 * 
 * @author Leni Kirilov
 * 
 */
public class DrServiceConsumer {
	
	public void displayDataRetrievalServiceConsumed(PrintStream out) {
		out.println("<br><br>----------displayDataRetrievalServiceConsumed-----------<br><br><br>");

		List<RetrievedCake> cakes = new DRClient().retrieveDrCakes();

		for (RetrievedCake cake : cakes) {
			out.printf("%s <br>", cake.toString());
		}
	}
	
	public List<RetrievedCake> getRetrievedCakes(){
		return new DRClient().retrieveDrCakes();
	}
}
