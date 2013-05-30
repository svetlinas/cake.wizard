package bg.cakerecipes.uiservice.restclients;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import bg.cakerecipes.daoservices.rest.model.Cake;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.api.uri.UriBuilderImpl;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class DAOClient extends AbstractClient {
	
	private final String REST_PATH = "cakes";

	public boolean writeCake(Cake cake) {
		final Form form = new Form();
		form.add("name", cake.getName());
		form.add("ingredients", cake.getIngredients());
		form.add("recipe", cake.getRecipe());

		final ClientResponse response = getWebService(REST_PATH)
				.type(MediaType.APPLICATION_FORM_URLENCODED)
				.post(ClientResponse.class, form);
		if (response.getStatus() != 204) {
			System.out.println("Something went wrong!");
			return false;
		}
		return true;
	}

	public List<Cake> readCakes() {
		final List<Cake> cakes = Arrays.asList(unparseJsonResponse());
		return cakes;
	}


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
		return getBuilder(REST_PATH).get(Cake[].class);
	}
	
	private Cake[] unparseJsonResponse(MultivaluedMap<String, String> queryParameters) {
		return getBuilder(queryParameters, REST_PATH).get(Cake[].class);
	}

}
