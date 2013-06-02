package bg.cakerecipes.externalservices.json;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import bg.cakerecipes.externalservices.model.ExternalCake;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.uri.UriBuilderImpl;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class JsonExternalCakeDAO {

	private static final String IMAGE_URL = "/files/lib/600x350/";
	private static final String RID_VALUE = "Rid";
	private static final String RECIPE_VALUE = "Preparation";
	private static final String TITLE_VALUE = "Title";
	private static final String QUERY_PARAM_SIZE_VALUE = String.valueOf(30);
	private static final String QUERY_PARAM_SIZE_ID = "size";
	private static final String QUERY_PARAM_RID_VALUE = String.valueOf(24);
	private static final String QUERY_PARAM_RID_ID = "rcat_id";
	private static final String ROOT_ELEMENT = "data";
	private static final String EXTERNAL_HOST_URL = "http://recepti.gotvach.bg";
	private static final String QUERY_PARAM_ACTION_VALUE = "getRSearchRecipes";
	private static final String QUERY_PARAM_ACTION_KEY = "action";
	private static final String REST_URL = "/data.php";
	private final WebResource service;

	public JsonExternalCakeDAO() {
		final ClientConfig config = new DefaultClientConfig();
		final Client client = Client.create(config);
		service = client.resource(getServiceURI());
	}

	@SuppressWarnings("unchecked")
	public List<ExternalCake> getAllCakes() {
		final List<ExternalCake> cakes = new ArrayList<ExternalCake>();
		Map<String, String> cakeImages = new HashMap<String, String>();
		
		final JSONObject object = getArrayWithDataToBeRetrieved();
		final Set<String> keySet = object.keySet();
		for (String key : keySet) {
			if(key.equals("Pics")) {
				cakeImages = (Map<String, String>) object.get(key);
				continue;
			}
			try {
				cakes.add(getCakeFromJsonResponse(object, key));
			} catch (RuntimeException e) {
				System.out.println("Parsing external rest service failed");
			}
		}
		connectCakesImages(cakes, cakeImages);
		return cakes;
	}

	@SuppressWarnings("unchecked")
	private ExternalCake getCakeFromJsonResponse(final JSONObject object, String string) {
		final Map<String,String> innerItem = (Map<String, String>) object.get(string);
		String cakeName = innerItem.get(TITLE_VALUE);
		String recipe = innerItem.get(RECIPE_VALUE);
		String category = innerItem.get(RID_VALUE);
		
		
		final ExternalCake cakeResult = new ExternalCake();
		cakeResult.setRid(category);
		cakeResult.setPreparation(recipe);
		cakeResult.setTitle(cakeName);
		return cakeResult;
	}

	private void connectCakesImages(List<ExternalCake> cakes, Map<String, String> cakeImages) {
		for (ExternalCake externalCake : cakes) {
			final StringBuilder builder = new StringBuilder();
			builder.append(EXTERNAL_HOST_URL);
			builder.append(IMAGE_URL);
			builder.append(cakeImages.get(externalCake.getRid()));
			externalCake.setImageUrl(builder.toString());
		}
	}
	
	private MultivaluedMap<String, String> getIdsAsQueryParameters() {
		final MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add(QUERY_PARAM_RID_ID, QUERY_PARAM_RID_VALUE);
		queryParameters.add(QUERY_PARAM_SIZE_ID, QUERY_PARAM_SIZE_VALUE);
		return queryParameters;
	}

	private JSONObject getArrayWithDataToBeRetrieved() {
		try {
			final String resource = getResource().toString();
			final JSONObject jsonObj = (JSONObject) new JSONParser().parse(resource);
			return ((JSONObject) jsonObj.get(ROOT_ELEMENT));
		} catch (ParseException e) {
			throw new RuntimeException("Cannot parse the retrieved data", e);
		} 
	}

	private StringBuilder getResource() {
		final StringBuilder builder = new StringBuilder();
		builder.append(unparseXmlResponse());
		return builder;
	}
	
	private String unparseXmlResponse() {
		return getBuilder(getIdsAsQueryParameters()).get(String.class);
	}
	
	private Builder getBuilder(MultivaluedMap<String, String> queryParameters) {
		return service.path(REST_URL).queryParam(QUERY_PARAM_ACTION_KEY, QUERY_PARAM_ACTION_VALUE).queryParams(queryParameters).accept(MediaType.APPLICATION_XML);
	}
	
	private URI getServiceURI() {
		return UriBuilderImpl.fromUri(EXTERNAL_HOST_URL).build();
	}
}
