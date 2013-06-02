package bg.cakerecipes.externalservices.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bg.cakerecipes.externalservices.json.JsonExternalCakeDAO;

@Path("/external-cakes")
public class ExternalCakeService {

	private final JsonExternalCakeDAO dao;
	
	public ExternalCakeService() {
		this.dao = new JsonExternalCakeDAO();
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getRetrievedCakes() {
		return dao.getAllCakes();
	}
	
}
