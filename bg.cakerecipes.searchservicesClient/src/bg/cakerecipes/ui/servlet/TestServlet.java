package bg.cakerecipes.ui.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import bg.cakerecipes.daoservices.rest.model.Cake;
import bg.cakerecipes.ui.servlet.consumers.DaoServiceConsumer;
import bg.cakerecipes.ui.servlet.consumers.SearchServiceConsumer;

/**
 * TestServlet for proving that clients and services are integrated
 */
//TODO split into 2 servlets - one for show and one for testing displaying ugly data  as strings
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		DaoServiceConsumer daoConsumer = new DaoServiceConsumer();
		List<Cake> cakes = daoConsumer.getDBCakes();
		
		String query = extractQuery(request);
		if(! "".equals(query)){
			cakes = new SearchServiceConsumer().sortCakes(query, cakes);
		}
		
		try {
			out.print(getJsonArray(cakes));
		} finally {
			out.close();
		}
	}
	
	private String extractQuery(HttpServletRequest request){
		final String searchWords = request.getParameter("request");
		final String query = getSearchRequest(searchWords);
		return query.trim();
	}

	private String getSearchRequest(String searchRequest) {
		String rawResult = searchRequest.split(":")[1];
		return rawResult.substring(0, rawResult.length()-1).replace("\"", "");
	}
	
	@SuppressWarnings("unchecked")
	public static JSONArray getJsonArray(List<Cake> list) {
		JSONArray array = new JSONArray();
		for (Cake cake : list) {
			array.add(getJson(cake));
		}
		return array;
	}

	@SuppressWarnings("unchecked")
	private static JSONObject getJson(Cake c) {

		final JSONObject cake_item = new JSONObject();
		cake_item.put("id", c.getId());
		cake_item.put("name", c.getName());
		cake_item.put("categories", c.getCategories());
		cake_item.put("recipe", c.getRecipe());
		cake_item.put("img", c.getImageUrl());
		return cake_item;
	}

	protected void testServices(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		PrintStream out = new PrintStream(response.getOutputStream());
		DaoServiceConsumer daoConsumer = new DaoServiceConsumer();

		// List<Cake> cakes = new ArrayList<Cake>();

		// new
		// SearchServiceConsumer().displaySearchServiceConsumed(daoConsumer.getDBCakes(),
		// out);
		new SearchServiceConsumer().displaySearchServiceConsumed(daoConsumer.getDBCakes(), out);

		out.flush();
		out.close();
	}

}
