package bg.cakerecipes.webcrawlerservices.service;

import java.util.List;

import bg.cakerecipes.webcrawlerservices.crawl.BasicCrawler;
import bg.cakerecipes.webcrawlerservices.crawl.model.CakeMapper;
import bg.cakerecipes.webcrawlerservices.crawl.model.WebCrawlerCake;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class WebCrawlerController {

	public List<WebCrawlerCake> getAllCakes() {
		return CakeMapper.htmlCakes;
	}
	
	public void runCrawler() {
		final int numberOfCrawlers = 4;
		final CrawlConfig config = getCrawlConfig();

		try {
			final CrawlController controller = getCrawlController(config);
			controller.addSeed("http://www.gotvetesmen.com/recipes/categories/desserts/cake/index.php?pageID=1");
			controller.start(BasicCrawler.class, numberOfCrawlers);
		} catch (Exception e) {
			throw new RuntimeException("Could not initialize CrawlerController", e);
		}

		// for(Cake cake : CakeMapper.htmlCakes){
		// System.out.println(cake.toString());
		// System.out.println("\n\n");
		// }
	}

	private CrawlController getCrawlController(final CrawlConfig config) throws Exception {
		final PageFetcher pageFetcher = new PageFetcher(config);
		final RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		final RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		return new CrawlController(config, pageFetcher, robotstxtServer);
	}

	private CrawlConfig getCrawlConfig() {
		// folder where intermediate crawl data is stored.
		final String crawlStorageFolder = "data/crawler";

		final CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder(crawlStorageFolder);
		config.setPolitenessDelay(1000);
		config.setMaxDepthOfCrawling(4);
		config.setMaxPagesToFetch(1000);
		config.setResumableCrawling(false);
		return config;
	}

	public static void main(String[] args) throws Exception {
		final WebCrawlerController main = new WebCrawlerController();
		main.runCrawler();
	}
}