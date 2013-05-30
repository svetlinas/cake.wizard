package bg.cakerecipes.daoservices.db.model;

import java.util.List;

public interface IDBCakeDAO {
	
	public List<IDBCake> getCakes(List<Long> ids);
	
	public List<IDBCake> getAllCakes();
	
	public void addCake(IDBCake cakeToBeAdded) throws DBCakeDAOException;

}
