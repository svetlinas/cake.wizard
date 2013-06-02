package bg.cakerecipes.daoservices.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bg.cakerecipes.daoservices.db.model.DBCake;
import bg.cakerecipes.daoservices.db.model.IDBCake;

public class DBCakeDAO implements IDBCakeDAO {

	private static final String PERSISTENCE_UNIT_NAME = "cakes";

	private final EntityManagerFactory factory;

	public DBCakeDAO() throws DBCakeDAOException {
		factory = createEntityManagerFactory();
	}

	@Override
	public List<IDBCake> getCakes(List<Long> ids) {
		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("getCakesById");
			query.setParameter("ids", ids);

			List<IDBCake> resultCakes = new ArrayList<IDBCake>(ids.size());
			for (Object cake : query.getResultList()) {
				resultCakes.add((DBCake) cake);
			}
			return resultCakes;
		} finally {
			manager.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<IDBCake> getAllCakes() {
		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("getAllCakes");
			List<IDBCake> cakes = query.getResultList();

			return cakes;
		} finally {
			manager.close();
		}
	}

	@Override
	public void addCake(IDBCake cakeToBeAdded) throws DBCakeDAOException {
		final EntityManager manager = factory.createEntityManager();
		final EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(cakeToBeAdded);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new DBCakeDAOException("The entry could not make it to the DB", e);
		} finally {
			manager.close();
		}
	}

	private EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

}
