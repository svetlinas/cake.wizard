package bg.cakerecipes.daoservices.db.model;

public class DBQueryConstants {

	public static final String KEY_getCakesById = "getCakesById";
	public static final String QUERY_getCakesById = "SELECT c FROM DBCake c WHERE c.id in :ids";
	
	public static final String KEY_getAllCakes = "getAllCakes";
	public static final String QUERY_getAllCakes = "SELECT e FROM DBCake e";
}
