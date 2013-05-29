package bg.cakerecipes.drservices.restservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bg.cakerecipes.drservices.dr.model.RetrievedCake;
import bg.cakerecipes.drservices.dr.model.RetrievedCakeDAO;

@Path("/raw-cakes")
public class RetrievedCakeService {

	private final RetrievedCakeDAO dao;
	
	public RetrievedCakeService() {
		super();
		this.dao = new RetrievedCakeDAO();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<RetrievedCake> getRetrievedCakes() {
		return dao.getAllCakes();
	}
	
}
