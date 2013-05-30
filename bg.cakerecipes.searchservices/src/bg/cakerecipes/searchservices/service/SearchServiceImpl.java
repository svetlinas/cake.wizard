package bg.cakerecipes.searchservices.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

/**
 * Stub implementation of the search service
 * 
 * @author Leni Kirilov
 * 
 */
@WebService(targetNamespace = "http://service.searchservices.cakerecipes.bg/", endpointInterface = "bg.cakerecipes.searchservices.service.SearchService", portName = "SearchServiceImplPort", serviceName = "SearchServiceImplService")
public class SearchServiceImpl implements SearchService {

	// TODO real implementation is due
	public List<Entry> query(String keyword) {
		List<Entry> list = new ArrayList<Entry>();

		Entry e = new Entry();
		e.setId("object-id-1");
		e.setRank(new Long(10));

		list.add(e);

		return list;
	}

	// TODO real implementation is due
	@Override
	public void buildIndexTree(List<Object> objects) {
		System.out.println("Build tree for objects " + objects.size() + " done!");
	}

}
