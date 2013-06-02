package bg.cakerecipes.client.rest;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import bg.cakerecipes.client.ServicesConstants;
import bg.cakerecipes.externalservices.model.ExternalCake;

import com.sun.jersey.api.uri.UriBuilderImpl;

public class ExternalServicesClient extends AbstractClient {

	private final String REST_PATH = "external-cakes";

	public List<ExternalCake> retrieveExternalCakes() {
		return Arrays.asList(getBuilder(REST_PATH).get(ExternalCake[].class));
	}

	@Override
	public URI getServiceURI() {
		return UriBuilderImpl.fromUri(ServicesConstants.EXTERNAL_SERVICE_URL).build();
	}

}
