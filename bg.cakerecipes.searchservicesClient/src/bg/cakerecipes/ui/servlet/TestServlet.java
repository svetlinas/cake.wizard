package bg.cakerecipes.ui.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OutputStream outs = response.getOutputStream();
		PrintStream out = new PrintStream(outs);

		displayDaoServiceConsumed(out);
		displayDataRetrievalServiceConsumed(out);
		
		new SearchServiceConsumer().displaySearchServiceConsumed(out);
		
		out.flush();
		out.close();
	}

	private void displayDaoServiceConsumed(PrintStream out) {
		out.println("----------displayDaoServiceConsumed-----------<br><br>");
	}

	private void displayDataRetrievalServiceConsumed(PrintStream out) {
		out.println("----------displayDataRetrievalServiceConsumed-----------<br><br>");
	}
}
