package bg.cakerecipes.uiservice.restclients;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public abstract class AbstractClient {
	
	protected final WebResource service;

	public AbstractClient() {
		final ClientConfig config = new DefaultClientConfig();
		final Client client = Client.create(config);
		service = client.resource(getServiceURI());
	}
	
	protected abstract URI getServiceURI();
	
	protected WebResource getWebService(String restPath) {
		return service.path("rest").path(restPath);
	}
	
	protected Builder getBuilder(String restPath) {
		return getWebService(restPath).accept(MediaType.APPLICATION_XML);
	}
	
	protected Builder getBuilder(MultivaluedMap<String, String> queryParameters, String restPath) {
		return getWebService(restPath).queryParams(queryParameters)
				.accept(MediaType.APPLICATION_XML);
	}

}
