package bg.cakerecipes.client.rest;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import bg.cakerecipes.client.ServicesConstants;
import bg.cakerecipes.webcrawlerservices.crawl.model.WebCrawlerCake;

import com.sun.jersey.api.uri.UriBuilderImpl;

/**
 * @author Leni Kirilov
 * 
 */
public class WebCrawlerClient extends AbstractClient {

	private final String REST_PATH = "web-cakes";

	public List<WebCrawlerCake> retrieveWebCakes() {
		return Arrays.asList(getBuilder(REST_PATH).get(WebCrawlerCake[].class));
	}

	@Override
	public URI getServiceURI() {
		return UriBuilderImpl.fromUri(ServicesConstants.WEB_CRAWLER_SERVICE_URL).build();
	}
}