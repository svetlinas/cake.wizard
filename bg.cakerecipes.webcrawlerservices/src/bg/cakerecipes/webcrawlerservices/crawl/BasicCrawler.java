package bg.cakerecipes.webcrawlerservices.crawl;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import bg.cakerecipes.webcrawlerservices.crawl.model.CakeMapper;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

public class BasicCrawler extends WebCrawler {

	private static final String COMMENTS = "comments";
	private static final String HREF_PAGEID = "http://www.gotvetesmen.com/recipes/categories/desserts/cake/index.php?pageid";
	private static final String HREF_CAKE_RECIPE = "http://www.gotvetesmen.com/recipes/categories/desserts/cake/recipe_";
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|mid|mp2|mp3|mp4|wav|avi|mov|mpeg|ram|m4v|pdf"
			+ "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

	private static Set<String> visitedPages = new HashSet<String>();

	@Override
	public boolean shouldVisit(WebURL url) {
		final String href = url.getURL().toLowerCase();
		if (visitedPages.contains(href)) {
			return false;
		}
		
		boolean shouldVisit = shouldBeVisited(href);
		if (shouldVisit) {
			visitedPages.add(href);
		}
		return shouldVisit;
	}

	@Override
	public void visit(Page page) {
		CakeMapper.parseCakes(page);
	}
	
	private boolean shouldBeVisited(String href) {
		return !FILTERS.matcher(href).matches() && !href.contains(COMMENTS)
				&& (href.startsWith(HREF_CAKE_RECIPE) || href.startsWith(HREF_PAGEID));
	}
}