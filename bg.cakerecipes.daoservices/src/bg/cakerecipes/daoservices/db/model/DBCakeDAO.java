package bg.cakerecipes.daoservices.db.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class DBCakeDAO implements IDBCakeDAO {

	private static final String PERSISTENCE_UNIT_NAME = "cakes";

	private final EntityManagerFactory factory;

	public DBCakeDAO() throws DBCakeDAOException {
		factory = createEntityManagerFactory();
	}

	@Override
	public IDBCake getCake(Long id) {
		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("getCakeById");
			query.setParameter("id", id);

			DBCake cake = (DBCake) query.getSingleResult();
			return cake;
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
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(cakeToBeAdded);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw new DBCakeDAOException("", e);
		} finally {
			manager.close();
		}
	}

	private EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

}
