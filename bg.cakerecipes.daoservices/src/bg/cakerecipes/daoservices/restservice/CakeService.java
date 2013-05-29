package bg.cakerecipes.daoservices.restservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import bg.cakerecipes.daoservices.db.model.DBCake;
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

	public CakeService(IDBCakeDAO dao) {
		this.dao = dao;
	}

	@Override
	public Cake buildCake(IDBCake dbCake) {
		final Cake cake = new Cake();
		cake.setId(dbCake.getId());
		cake.setName(dbCake.getName());
		cake.setIngredients(dbCake.getIngredients());
		cake.setRecipe(dbCake.getRecipe());
		return cake;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Cake> getCakes(@QueryParam("id") List<Long> ids) {
		final List<Cake> cakes = new ArrayList<Cake>();
		if (ids == null || ids.size() == 0) {
			cakes.addAll(retrieveAllCakes());
		} else {
			for(Long id : ids){
				cakes.add(retrieveCake(id));
			}
		}
		return cakes;
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newCake(@FormParam("name") String name,
			@FormParam("ingredients") String ingredients,
			@FormParam("recipe") String recipe,
			@Context HttpServletResponse servletResponse) throws IOException {
		
		final DBCake dbCake = new DBCake();
		dbCake.setName(name);
		dbCake.setIngredients(ingredients);
		dbCake.setRecipe(recipe);
		
		putCakeInDB(dbCake);
	}

	private void putCakeInDB(DBCake dbCake) {
		try {
			dao.addCake(dbCake);
		} catch (DBCakeDAOException e) {
			throw new RuntimeException("Get: No Cakes were added to DB");
		}
	}

	private List<Cake> retrieveAllCakes() {
		final List<IDBCake> dbCakes = dao.getAllCakes();
		if (dbCakes.isEmpty()) {
			throw new RuntimeException("Get: No Cakes found");
		}
		final List<Cake> result = new ArrayList<Cake>();
		for (IDBCake idbCake : dbCakes) {
			result.add(buildCake(idbCake));
		}
		return result;
	}

	private Cake retrieveCake(Long id) {
		final IDBCake result = dao.getCake(id);
		if (result == null) {
			throw new RuntimeException("Get: Cake with " + id + " not found");
		}
		return buildCake(result);
	}

}
