package bg.cakerecipes.ui.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.cakerecipes.drservices.dr.model.RetrievedCake;

/**
 * TestServlet for proving that clients and services are integrated
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintStream out = new PrintStream(response.getOutputStream());
		DaoServiceConsumer daoConsumer = new DaoServiceConsumer();
		DrServiceConsumer drConsumer = new DrServiceConsumer();
		
		drConsumer.displayDataRetrievalServiceConsumed(out);
		daoConsumer.displayAllDbStoreCakes(out);
		
		out.println("<br> INTEGRATING DR into DAO");
		writeDrModelIntoDao(drConsumer.getRetrievedCakes(), daoConsumer, out);
		
		new SearchServiceConsumer().displaySearchServiceConsumed(out);

		out.flush();
		out.close();
	}
	
	private void writeDrModelIntoDao(List<RetrievedCake> retrievedCakes, DaoServiceConsumer daoConsumer, PrintStream out){
		for(RetrievedCake cake : retrievedCakes){
			
			out.printf("<br>Trying to write retrieved cake (name= %s )... ", cake.getName());
			boolean result = daoConsumer.writeDrCake2Dao(cake);
			
			if(result){
				out.println("SUCCES"); 
			}else{
				out.println("FAILED");
			}
		}
		
		daoConsumer.displayAllDbStoreCakes(out);
	}
}
