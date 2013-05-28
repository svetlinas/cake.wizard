package bg.cakerecipes.daoservices.restservice;

import bg.cakerecipes.daoservices.db.model.IDBCake;
import bg.cakerecipes.daoservices.model.Cake;

public interface ICakeBuilder {

	public Cake createCake(IDBCake cake);
}
