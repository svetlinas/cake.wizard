package bg.cakerecipes.webcrawlerservices.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bg.cakerecipes.webcrawlerservices.crawl.model.WebCrawlerCake;
import bg.cakerecipes.webcrawlerservices.service.WebCrawlerController;

@Path("/web-cakes")
public class WebCrawlerCakeService {
	
	private final WebCrawlerController webCrawler;
	
	public WebCrawlerCakeService() {
		webCrawler = new WebCrawlerController();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<WebCrawlerCake> getWebCrawlerCakes() {
		webCrawler.runCrawler();
		return webCrawler.getAllCakes();
	}
}
