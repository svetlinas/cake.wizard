package bg.cakerecipes.drservices.dr.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import bg.cakerecipes.drservices.dr.model.RetrievedCake;

/**
 * 
 * 	Class for reading JSON source with cakes
 * 
 * @author Svetlina Shopova
 *
 */
public class JsonRetrievedCakeDAO {

	private final String FILE_WITH_CONTENT = "resources/array.properties";

	public List<RetrievedCake> getAllCakes() {
		final List<RetrievedCake> cakes = new ArrayList<RetrievedCake>();

		final JSONArray array = getArrayWithDataToBeRetrieved();
		for (int i = 0; i < array.size(); i++) {
			
			final JSONArray cakeArray = ((JSONArray) array.get(i));
			final String name = (String) cakeArray.get(0);
			final List<String> contents = retrieveContents(cakeArray);
			final Double price = Double.parseDouble((String) cakeArray.get(4));
			
			cakes.add(new RetrievedCake(name, contents, price));
		}
		return cakes;
	}

	private List<String> retrieveContents(final JSONArray cakeArray) {
		final List<String> contents = new ArrayList<String>();

		final JSONArray arrayContent = (JSONArray) cakeArray.get(2);
		for (int j = 0; j < arrayContent.size(); j++) {
			contents.add(((String) arrayContent.get(j)));
		}

		final JSONArray arraySpecial = (JSONArray) cakeArray.get(3);
		for (int j = 0; j < arraySpecial.size(); j++) {
			contents.add(((String) arraySpecial.get(j)));
		}

		return contents;
	}

	private JSONArray getArrayWithDataToBeRetrieved() {
		try {
			final String resource = getResource().toString();
			final JSONObject jsonObj = (JSONObject) new JSONParser().parse(resource);
			return ((JSONArray) jsonObj.get("all"));
		} catch (ParseException e) {
			throw new RuntimeException("Cannot parse the retrieved data", e);
		} 
	}

	private StringBuilder getResource() {
		final BufferedReader reader = getBufferedReader();
		final StringBuilder fileData = new StringBuilder(1000);
		char[] buf = new char[1024];
		int numRead = 0;
		
		try {
			while ((numRead = reader.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
		} catch (IOException e) {
			throw new RuntimeException("Cannot read from the file specified", e);
		} finally {
			closeReader(reader);
		}
		return fileData;
	}

	private InputStreamReader getResourceReader() {
		try {
			final URL url = new URL("http://localhost:8080/bg.cakerecipes.drservices/" + FILE_WITH_CONTENT);
			return new InputStreamReader(url.openStream());
		} catch (IOException e) {
			throw new RuntimeException("The file cannot be loaded", e);
		}
	}

	private void closeReader(BufferedReader reader) {
		if (reader == null)
			return;
		try {
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException("Cannot close BufferedReader", e);
		}
	}

	private BufferedReader getBufferedReader() {
		return new BufferedReader(getResourceReader());
	}

}
