package bg.cakerecipes.daoservices.db.dao;

public class DBCakeDAOException extends Exception {

	private static final long serialVersionUID = 530564656535556605L;

	public DBCakeDAOException() {
		super();
	}
	
	public DBCakeDAOException(String message) {
		super(message);
	}
	
	public DBCakeDAOException(Throwable exception) {
		super(exception);
	}
	
	public DBCakeDAOException(String message, Throwable exception) {
		super(message, exception);
	}
}
