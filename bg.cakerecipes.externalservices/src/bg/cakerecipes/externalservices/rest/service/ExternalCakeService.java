package bg.cakerecipes.externalservices.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bg.cakerecipes.externalservices.json.JsonExternalCakeDAO;
import bg.cakerecipes.externalservices.model.ExternalCake;

@Path("/external-cakes")
public class ExternalCakeService {

	private final JsonExternalCakeDAO dao;
	
	public ExternalCakeService() {
		this.dao = new JsonExternalCakeDAO();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<ExternalCake> getRetrievedCakes() {
		return dao.getAllCakes();
	}
	
}
