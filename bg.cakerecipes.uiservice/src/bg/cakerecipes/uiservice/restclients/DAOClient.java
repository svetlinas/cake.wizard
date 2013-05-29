package bg.cakerecipes.uiservice.restclients;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import bg.cakerecipes.daoservices.model.Cake;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.api.uri.UriBuilderImpl;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class DAOClient implements IDAOClient {

	private final WebResource service;

	public DAOClient() {
		final ClientConfig config = new DefaultClientConfig();
		final Client client = Client.create(config);
		service = client.resource(getServiceURI());
	}

	@Override
	public boolean writeCake(Cake cake) {
		final Form form = new Form();
		form.add("name", cake.getName());
		form.add("ingredients", cake.getIngredients());
		form.add("recipe", cake.getRecipe());

		final ClientResponse response = service.path("rest").path("cakes")
				.type(MediaType.APPLICATION_FORM_URLENCODED)
				.post(ClientResponse.class, form);
		if (response.getStatus() != 204) {
			System.out.println("Something went wrong!");
			return false;
		}
		return true;
	}

	@Override
	public List<Cake> readCakes() {
		final List<Cake> cakes = Arrays.asList(unparseJsonResponse());
		return cakes;
	}


	@Override
	public List<Cake> readCakes(String... ids) {
		final MultivaluedMap<String, String> queryParameters = getIdsAsQueryParameters(ids);
		return Arrays.asList(unparseJsonResponse(queryParameters));
	}

	private MultivaluedMap<String, String> getIdsAsQueryParameters(String[] ids) {
		final MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		for (String id : ids) {
			queryParameters.add("id", id);
		}
		return queryParameters;
	}

	@Override
	public URI getServiceURI() {
		return UriBuilderImpl.fromUri(
				"http://localhost:8080/bg.cakerecipes.daoservices").build();
	}

	private Cake[] unparseJsonResponse() {
		return service.path("rest").path("cakes")
				.accept(MediaType.APPLICATION_XML).get(Cake[].class);
	}
	
	private Cake[] unparseJsonResponse(MultivaluedMap<String, String> queryParameters) {
		return service.path("rest").path("cakes")
				.queryParams(queryParameters)
				.accept(MediaType.APPLICATION_XML).get(Cake[].class);
	}

}
