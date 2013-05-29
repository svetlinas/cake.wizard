package bg.cakerecipes.uiservice.restclients;

import java.net.URI;
import java.util.List;

import bg.cakerecipes.daoservices.model.Cake;

public interface IDAOClient {
	
	public boolean writeCake(Cake cake);
	
	public List<Cake> readCakes();
	
	public List<Cake> readCakes(String... id);

	public URI getServiceURI();
}
