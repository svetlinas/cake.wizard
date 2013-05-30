package bg.cakerecipes.daoservices.rest;

import java.util.List;

import bg.cakerecipes.daoservices.db.model.IDBCake;
import bg.cakerecipes.daoservices.rest.model.Cake;


/**
 * 
 * 	Converts from DBCake model to Rest Model of a Cake
 * 
 * @author Leni Kirilov
 *
 */
public interface ICakeConverter {

	public Cake buildCake(IDBCake cake);
	
	public List<Cake> buildCakes(List<IDBCake> dbCakes);
}
