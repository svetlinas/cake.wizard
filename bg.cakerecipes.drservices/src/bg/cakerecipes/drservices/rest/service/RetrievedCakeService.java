package bg.cakerecipes.drservices.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bg.cakerecipes.drservices.dr.json.JsonRetrievedCakeDAO;
import bg.cakerecipes.drservices.dr.model.RetrievedCake;

@Path("/raw-cakes")
public class RetrievedCakeService {

	private final JsonRetrievedCakeDAO jsonDao;
	
	public RetrievedCakeService() {
		super();
		this.jsonDao = new JsonRetrievedCakeDAO();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<RetrievedCake> getRetrievedCakes() {
		return jsonDao.getAllCakes();
	}
	
}
