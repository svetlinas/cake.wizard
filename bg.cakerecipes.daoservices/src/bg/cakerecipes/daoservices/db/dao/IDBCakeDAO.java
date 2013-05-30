package bg.cakerecipes.daoservices.db.dao;

import java.util.List;

import bg.cakerecipes.daoservices.db.model.IDBCake;

public interface IDBCakeDAO {
	
	public List<IDBCake> getCakes(List<Long> ids);
	
	public List<IDBCake> getAllCakes();
	
	public void addCake(IDBCake cakeToBeAdded) throws DBCakeDAOException;

}
