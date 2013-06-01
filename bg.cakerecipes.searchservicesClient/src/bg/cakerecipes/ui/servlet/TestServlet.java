package bg.cakerecipes.ui.servlet;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TestServlet for proving that clients and services are integrated
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintStream out = new PrintStream(response.getOutputStream());

//		new DaoServiceConsumer().displayAllDbStoreCakes(out);

//		new DrServiceConsumer().displayDataRetrievalServiceConsumed(out);

		new SearchServiceConsumer().displaySearchServiceConsumed(out);

		out.flush();
		out.close();
	}
}
