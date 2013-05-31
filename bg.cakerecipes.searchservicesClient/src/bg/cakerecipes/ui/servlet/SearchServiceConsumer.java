package bg.cakerecipes.ui.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bg.cakerecipes.client.jaxws.SearchClient;

public class SearchServiceConsumer {
	private SearchClient search = new SearchClient();

	public void displaySearchServiceConsumed(PrintStream out) {
		
		out.println("----------displaySearchServiceConsumed-----------<br><br>");
		
		{
			out.println("Invoking buildIndexTree...<br>");
			List<Object> _buildIndexTree_arg0 = new ArrayList<Object>();
			Object _buildIndexTree_arg0Val1 = null;
			_buildIndexTree_arg0.add(_buildIndexTree_arg0Val1);
			this.search.buildIndexTree(_buildIndexTree_arg0);
		}
		{
			out.println("Invoking query...<br>");
			
			String queryKeyword = "shoko";
			Map<String, Long> rankingMap = this.search.query(queryKeyword);
			
			displayRankingChart(rankingMap, out);
		}
	}
	
	/**
	 *  Forms a chart of ranks in the result servlet 
	 */
	private void displayRankingChart(Map<String, Long> rankingMap, PrintStream out){
		
		//TODO display this chart sorted by rank (highest first) - may be this http://stackoverflow.com/questions/7965132/java-sort-hashmap-by-value ... but looks like overkill
		for (String objectId : rankingMap.keySet()) {
			out.println("<br>object-id= " + objectId + " -->");
			out.println("object-rank= " + rankingMap.get(objectId));
			out.println("<br>----------"); 
		}
	}
}
