package bg.cakerecipes.searchservices.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import bg.cakerecipes.searchservices.service.SearchService;
import bg.cakerecipes.searchservices.service.SearchServiceImplService;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final QName SERVICE_NAME = new QName(
			"http://service.searchservices.cakerecipes.bg/", "SearchServiceImplService");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		URL wsdlURL = SearchServiceImplService.WSDL_LOCATION;

		SearchServiceImplService ss = new SearchServiceImplService(wsdlURL, SERVICE_NAME);
		SearchService port = ss.getSearchServiceImplPort();
		
		OutputStream outs = response.getOutputStream();
		PrintStream out = new PrintStream(outs);

		{
			out.println("Invoking buildIndexTree...<br>");
			java.util.List<java.lang.Object> _buildIndexTree_arg0 = new java.util.ArrayList<java.lang.Object>();
			java.lang.Object _buildIndexTree_arg0Val1 = null;
			_buildIndexTree_arg0.add(_buildIndexTree_arg0Val1);
			port.buildIndexTree(_buildIndexTree_arg0);
		}
		{
	        out.println("Invoking query...<br>");
	        java.lang.String _query_arg0 = "_query_arg0-491685184";
	        java.util.List<bg.cakerecipes.searchservices.service.Entry> _query__return = port.query(_query_arg0);
	        out.println("<br>query.result=" + _query__return);
	        out.println("<br>query.result=" + _query__return.get(0).getId());
	        out.println("<br>query.result=" + _query__return.get(0).getRank());
		}

		out.flush();
		out.close();
	}

}
