package bg.cakerecipes.ui.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.cakerecipes.drservices.dr.model.RetrievedCake;
import bg.cakerecipes.externalservices.model.ExternalCake;

/**
 * TestServlet for proving that clients and services are integrated
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintStream out = new PrintStream(response.getOutputStream());
		DaoServiceConsumer daoConsumer = new DaoServiceConsumer();
		DrServiceConsumer drConsumer = new DrServiceConsumer();
		ExternalServiceConsumer extConsumer = new ExternalServiceConsumer();

//		drConsumer.displayDataRetrievalServiceConsumed(out);
//		daoConsumer.displayAllDbStoreCakes(out);
//		extConsumer.displayExternalServiceConsumed(out);

//		out.println("<br> INTEGRATING DR into DAO");
//		writeDrModelIntoDao(drConsumer.getRetrievedCakes(), daoConsumer, out);
//
//		out.println("<br> INTEGRATING External into DAO");
//		writeExternalModelIntoDao(extConsumer.getExternalCakes(), daoConsumer, out);

		
//		List<Cake> cakes = new ArrayList<Cake>();
		
//		new SearchServiceConsumer().displaySearchServiceConsumed(daoConsumer.getDBCakes(), out);
		new SearchServiceConsumer().displaySearchServiceConsumed(daoConsumer.getDBCakes(), out);

		out.flush();
		out.close();
	}

	private void writeDrModelIntoDao(List<RetrievedCake> retrievedCakes, DaoServiceConsumer daoConsumer, PrintStream out) {
		for (RetrievedCake cake : retrievedCakes) {
			out.printf("<br>Trying to write retrieved cake (name= %s )... ", cake.getName());
			boolean result = daoConsumer.writeDrCake2Dao(cake);
			printResultString(out, result);
		}

		daoConsumer.displayAllDbStoreCakes(out);
	}

	private void writeExternalModelIntoDao(List<ExternalCake> externalCakes, DaoServiceConsumer daoConsumer,
			PrintStream out) {
		for (ExternalCake cake : externalCakes) {
			out.printf("<br>Trying to write retrieved cake (name= %s )... ", cake.getName());
			boolean result = daoConsumer.writeExternalCake2Dao(cake);
			printResultString(out, result);
		}

		daoConsumer.displayAllDbStoreCakes(out);
	}

	private void printResultString(PrintStream out, boolean result) {
		if (result) {
			out.println("SUCCESS");
		} else {
			out.println("FAILED");
		}
	}

}
