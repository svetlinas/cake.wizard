package bg.cakerecipes.externalservices.json;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.uri.UriBuilderImpl;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class JsonExternalCakeDAO {

	private final WebResource service;

	public JsonExternalCakeDAO() {
		final ClientConfig config = new DefaultClientConfig();
		final Client client = Client.create(config);
		service = client.resource(getServiceURI());
	}

	public String getAllCakes() {
		return unparseXmlResponse();
	}

	private URI getServiceURI() {
		return UriBuilderImpl.fromUri("http://recepti.gotvach.bg").build();
	}
	
	private String unparseXmlResponse() {
		return getBuilder(getIdsAsQueryParameters()).get(String.class);
	}
	
	private MultivaluedMap<String, String> getIdsAsQueryParameters() {
		final MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("rcat_id", String.valueOf(24));
		queryParameters.add("size", String.valueOf(30));
		return queryParameters;
	}

	private Builder getBuilder(MultivaluedMap<String, String> queryParameters) {
		return service.path("/data.php").queryParam("action", "getRSearchRecipes").queryParams(queryParameters).accept(MediaType.APPLICATION_XML);
	}
	
}
