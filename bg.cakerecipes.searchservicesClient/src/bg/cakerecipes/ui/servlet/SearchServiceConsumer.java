package bg.cakerecipes.ui.servlet;

import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import bg.cakerecipes.client.jaxws.SearchClient;
import bg.cakerecipes.daoservices.rest.model.Cake;

public class SearchServiceConsumer {
	private SearchClient search = new SearchClient();

	public void displaySearchServiceConsumed(List<Cake> dbCakes, PrintStream out) {
		
		out.println("----------displaySearchServiceConsumed-----------<br><br>");
		
//		List<SearchCake> searchCakes = SearchCakeConverter.convert2SearchCakes(dbCakes);
		
//		this.search.query(searchCakes, "shoko"); //TODO pass this from html
		
		{
			out.println("Invoking query...<br>");
			
			String queryKeyword = "shoko";
//			Map<String, Long> rankingMap = this.search.query(searchCakes, queryKeyword);
			
//			displayRankingChart(rankingMap, out);
		}
	}
	
	/**
	 *  Forms a chart of ranks in the result servlet 
	 */
	private void displayRankingChart(Map<String, Long> rankingMap, PrintStream out){
		
		Map<String, Long> sortedMap = sortByValue(rankingMap);
		
		for (String objectId : sortedMap.keySet()) {
			out.println("<br>object-rank= " + rankingMap.get(objectId));
			out.println("object-id= " + objectId + " -->");
			out.println("<br>----------"); 
		}
	}

	/**
	 * Very cool algorithm from here: http://stackoverflow.com/questions/7965132/java-sort-hashmap-by-value
	 * 
	 * @param map
	 * @return sorted by value LinkedHashMap
	 */
	//TODO move to Query service may be?
	private static Map<String, Long> sortByValue(Map<String, Long> map) {
        List<Map.Entry<String, Long>> list = new LinkedList<Map.Entry<String, Long>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {

            public int compare(Map.Entry<String, Long> m1, Map.Entry<String, Long> m2) {
                return (m2.getValue()).compareTo(m1.getValue());
            }
        });

        Map<String, Long> result = new LinkedHashMap<String, Long>();
        for (Map.Entry<String, Long> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
