package bg.cakerecipes.ui.servlet;

import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import bg.cakerecipes.client.jaxws.SearchCakeConverter;
import bg.cakerecipes.client.jaxws.SearchClient;
import bg.cakerecipes.client.jaxws.searchSrv.SearchCake;
import bg.cakerecipes.daoservices.rest.model.Cake;

public class SearchServiceConsumer {
	private SearchClient search = new SearchClient();

	public void displaySearchServiceConsumed(List<Cake> dbCakes, PrintStream out) {
		
		out.println("----------displaySearchServiceConsumed-----------<br><br>");
		
		List<SearchCake> searchCakes = SearchCakeConverter.convertToSearchCakes(dbCakes);
		
		{
			
			String queryKeyword = "CHOCO";
			
			out.println("Invoking query...[<<<" + queryKeyword + ">>>] <br>");
			
			
			Map<Long, Long> rankingMap = this.search.query(searchCakes, queryKeyword);
			
			displayRankingChart(rankingMap, out);
		}
	}
	
	/**
	 *  Forms a chart of ranks in the result servlet 
	 */
	private void displayRankingChart(Map<Long, Long> rankingMap, PrintStream out){
		
		Map<Long, Long> sortedMap = sortByValue(rankingMap);
		
		for (Long objectId : sortedMap.keySet()) {
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
	private static Map<Long, Long> sortByValue(Map<Long, Long> map) {
        List<Map.Entry<Long, Long>> list = new LinkedList<Map.Entry<Long, Long>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Long, Long>>() {

            public int compare(Map.Entry<Long, Long> m1, Map.Entry<Long, Long> m2) {
                return (m2.getValue()).compareTo(m1.getValue());
            }
        });

        Map<Long, Long> result = new LinkedHashMap<Long, Long>();
        for (Map.Entry<Long, Long> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
