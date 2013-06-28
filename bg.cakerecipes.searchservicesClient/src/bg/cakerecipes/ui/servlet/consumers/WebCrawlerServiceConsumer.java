package bg.cakerecipes.ui.servlet.consumers;

import java.io.PrintStream;
import java.util.List;

import bg.cakerecipes.client.rest.WebCrawlerClient;
import bg.cakerecipes.webcrawlerservices.crawl.model.WebCrawlerCake;

public class WebCrawlerServiceConsumer {
	
	public void displayExternalServiceConsumed(PrintStream out) {
		out.println("<br><br>----------displayWebCrawlerServiceConsumed-----------<br><br><br>");

		List<WebCrawlerCake> cakes = new WebCrawlerClient().retrieveWebCakes();

		for (WebCrawlerCake cake : cakes) {
			out.printf("%s <br>", cake.toString());
		}
	}
	
	public List<WebCrawlerCake> getWebCakes(){
		return new WebCrawlerClient().retrieveWebCakes();
	}

}
