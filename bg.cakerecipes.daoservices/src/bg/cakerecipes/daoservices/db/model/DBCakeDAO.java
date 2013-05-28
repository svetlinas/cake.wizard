package bg.cakerecipes.daoservices.db.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class DBCakeDAO implements IDBCakeDAO {

	private static final String PERSISTENCE_UNIT_NAME = "cakes";

	private final DataSource dataSource;
	private final EntityManagerFactory factory;

	public DBCakeDAO() throws DBCakeDAOException {
		dataSource = getDataSource();
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
			Query query = manager.createNamedQuery("listAllCakes");
			List<IDBCake> cakes = query.getResultList();

			return cakes;
		} finally {
			manager.close();
		}
	}

	@Override
	public void addCake(IDBCake cakeToBeAdded) {
		EntityManager manager = factory.createEntityManager();
		try {
			manager.persist(cakeToBeAdded);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}

	private DataSource getDataSource() throws DBCakeDAOException {
		try {
			InitialContext context = new InitialContext();
			return (DataSource) context.lookup("java:comp/env/jdbc/MySQLDB");
		} catch (NamingException ex) {
			throw new DBCakeDAOException("Could not lookup Datasource", ex);
		}
	}

	private EntityManagerFactory createEntityManagerFactory() {
		Map<Object, Object> properties = new HashMap<Object, Object>();
		properties
				.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, dataSource);
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,
				properties);
	}

}
