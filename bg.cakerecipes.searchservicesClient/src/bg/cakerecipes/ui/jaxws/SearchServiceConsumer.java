package bg.cakerecipes.ui.jaxws;

import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import bg.cakerecipes.searchservices.service.Entry;
import bg.cakerecipes.searchservices.service.SearchService;
import bg.cakerecipes.searchservices.service.SearchServiceImplService;

public class SearchServiceConsumer {

	public void displaySearchServiceConsumed(PrintStream out) {
		
		out.println("----------displaySearchServiceConsumed-----------<br>");
		
		QName SERVICE_NAME = new QName("http://service.searchservices.cakerecipes.bg/", "SearchServiceImplService");
		URL wsdlURL = SearchServiceImplService.WSDL_LOCATION;

		SearchServiceImplService ss = new SearchServiceImplService(wsdlURL, SERVICE_NAME);
		SearchService port = ss.getSearchServiceImplPort();

		{
			out.println("Invoking buildIndexTree...<br>");
			List<Object> _buildIndexTree_arg0 = new ArrayList<Object>();
			Object _buildIndexTree_arg0Val1 = null;
			_buildIndexTree_arg0.add(_buildIndexTree_arg0Val1);
			port.buildIndexTree(_buildIndexTree_arg0);
		}
		{
			out.println("Invoking query...<br>");
			
			String queryKeyword = "shoko";
			List<Entry> rankingMap = port.query(queryKeyword);
			
			displayRankingChart(rankingMap, out);
		}

	}
	
	/**
	 *  Forms a chart of ranks in the result servlet 
	 */
	private void displayRankingChart(List<Entry> rankingMap, PrintStream out){
		for (Entry e : rankingMap) {
			out.println("<br>object-id= " + e.getId() + " -->");
			out.println("object-rank= " + e.getRank());
			out.println("<br>----------"); 
		}
	}
}
