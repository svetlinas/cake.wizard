package bg.cakerecipes.daoservices.db.model;

import java.util.List;

public interface IDBCakeDAO {
	
	public IDBCake getCake(Long id);
	
	public List<IDBCake> getAllCakes();
	
	public void addCake(IDBCake cakeToBeAdded);

}
