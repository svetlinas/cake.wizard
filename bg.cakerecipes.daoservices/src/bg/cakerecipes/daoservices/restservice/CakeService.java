package bg.cakerecipes.daoservices.restservice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import bg.cakerecipes.daoservices.db.model.DBCakeDAO;
import bg.cakerecipes.daoservices.db.model.DBCakeDAOException;
import bg.cakerecipes.daoservices.db.model.IDBCake;
import bg.cakerecipes.daoservices.db.model.IDBCakeDAO;
import bg.cakerecipes.daoservices.model.Cake;

@Path("/cakes")
public class CakeService implements ICakeBuilder {

	private static final Logger logger = Logger.getLogger(CakeService.class);
	private final IDBCakeDAO dao;

	public CakeService() {
		try {
			this.dao = new DBCakeDAO();
		} catch (DBCakeDAOException ex) {
			logger.error("Failed to create Cake", ex);
			throw new WebApplicationException(
					HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Cake createCake(IDBCake cake) {
		final Cake result = new Cake();
		result.setId(cake.getId());
		result.setName(cake.getName());
		// result.setProducts(cake.getProducts());
		result.setRecipe(cake.getRecipe());
		return result;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cake> getCakes(@QueryParam("id") Long id) {
		final List<Cake> cakes = new ArrayList<Cake>();
		if (id == null) {
			cakes.addAll(retrieveAllCakes());
		} else {
			cakes.add(retrieveCake(id));
		}
		return cakes;
	}

	private List<Cake> retrieveAllCakes() {
		final List<IDBCake> dbCakes = dao.getAllCakes();
		if(dbCakes.isEmpty()) {
			throw new RuntimeException("Get: No Cakes found");
		}
		final List<Cake> result = new ArrayList<Cake>();
		for (IDBCake idbCake : dbCakes) {
			result.add(createCake(idbCake));
		}
		return result;
	}

	private Cake retrieveCake(Long id) {
		final IDBCake result = dao.getCake(id);
		if (result == null) {
			throw new RuntimeException("Get: Cake with " + id + " not found");
		}
		return createCake(result);
	}

}
