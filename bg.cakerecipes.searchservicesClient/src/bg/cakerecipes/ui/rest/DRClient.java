package bg.cakerecipes.ui.rest;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import bg.cakerecipes.drservices.dr.model.RetrievedCake;

import com.sun.jersey.api.uri.UriBuilderImpl;

public class DRClient extends AbstractClient {

	private final String REST_PATH = "raw-cakes";

	public List<RetrievedCake> readData() {
		return Arrays.asList(getBuilder(REST_PATH).get(RetrievedCake[].class));
	}
	
	@Override
	public URI getServiceURI() {
		return UriBuilderImpl.fromUri(
				"http://localhost:8080/bg.cakerecipes.drservices").build();
	}
}
