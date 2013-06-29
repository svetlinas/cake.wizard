package bg.cakerecipes.searchservices.engine.lucene;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import bg.cakerecipes.searchservices.engine.CakeSearchEngine;
import bg.cakerecipes.searchservices.service.model.SearchCake;

/**
 * Search engine wrapper with more complex capabilities.<br>
 * The foundations is apache Lucene.<br>
 * <br>
 * It allows queries like this:<br>
 * "cake" - exact match<br>
 * "cake*" - prefix cake<br>
 * "cake -chocolate" - any non-chocolate cake<br>
 * "cake -choco*"- any non-choco starting cake<br>
 * 
 * For more about the query language check out {@link MultiFieldQueryParser} <br>
 * <br>
 * <a href=
 * "http://www.avajava.com/tutorials/lessons/how-do-i-use-lucene-to-index-and-search-text-files.html"
 * > Cool tutorial for Lucene </a>
 * 
 * @author Leni Kirilov
 * 
 */
public class ComplexSearchEngine implements CakeSearchEngine {

	private static final String SEARCH_SERVICE_URL = "http://localhost:8080/bg.cakerecipes.searchservices/";
	private final Version LUCENE_VERSION = Version.LUCENE_43;
	private Analyzer analyzer = null;

	private final String FILE_WITH_CONTENT = "resources/bulgarianST.properties";

	@Override
	public void initializeSearchAnalizer() {
		try {
			this.analyzer = new StandardAnalyzer(LUCENE_VERSION, getResourceReader());
		} catch (IOException e) {
			this.analyzer = new StandardAnalyzer(LUCENE_VERSION);
		}
	}

	@Override
	public Map<Long, Long> rankCakes(List<SearchCake> cakes, String query) {

		Directory indexDir = buildIndex(cakes);
		Map<Long, Long> idScoreMap = rankDocs(indexDir, query);

		return idScoreMap;
	}

	private InputStreamReader getResourceReader() {
		try {
			final URL url = new URL(SEARCH_SERVICE_URL + FILE_WITH_CONTENT);
			return new InputStreamReader(url.openStream());
		} catch (IOException e) {
			throw new RuntimeException("The file cannot be loaded", e);
		}
	}

	/**
	 * Builds index based on list of cakes<br>
	 * 
	 * @return directory containing the index
	 */
	private Directory buildIndex(List<SearchCake> cakes) {

		// Store the index in memory:
		Directory directory = new RAMDirectory();

		// To store an index on disk, use this instead:
		// Directory directory = FSDirectory.open("/tmp/testindex");
		IndexWriterConfig config = new IndexWriterConfig(LUCENE_VERSION, this.analyzer);

		IndexWriter iwriter = null;
		;
		try {
			iwriter = new IndexWriter(directory, config);

			List<Document> docs = convertCakesToDocument(cakes);

			iwriter.addDocuments(docs);

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed indexing", e);
		} finally {
			try {
				if (iwriter != null) {
					iwriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Not abled to close writer of index", e);
			}
		}

		return directory;
	}

	/**
	 * Conversion of Cake to SearchDocuments and its properties to fields.
	 * 
	 * @param cakes
	 * @return
	 */
	private List<Document> convertCakesToDocument(List<SearchCake> cakes) {
		List<Document> docs = new ArrayList<Document>(cakes.size());
		for (SearchCake cake : cakes) {

			Document doc = new Document();

			Field nameField = new Field(CakeFieldTypes.NAME.getFieldName(), cake.getName(), TextField.TYPE_STORED);
			nameField.setBoost(2F);
			doc.add(nameField);
			doc.add(new TextField(CakeFieldTypes.RECIPE.getFieldName(), cake.getRecipe(), Store.YES));
			doc.add(new Field(CakeFieldTypes.CATEGORIES.getFieldName(), Arrays.deepToString(cake.getCategories()
					.toArray()), TextField.TYPE_STORED));
			doc.add(new Field(CakeFieldTypes.ID.getFieldName(), "" + cake.getId(), TextField.TYPE_STORED));

			docs.add(doc);
		}

		return docs;
	}

	/**
	 * Perform ranking of a directory based on query.
	 * 
	 * @param directory
	 *            - index is located here
	 * @param queryPhrase
	 *            - the query
	 * @return map of doc/cake ID and score
	 */
	private Map<Long, Long> rankDocs(Directory directory, String queryPhrase) {
		DirectoryReader ireader;
		try {
			ireader = DirectoryReader.open(directory);
			IndexSearcher isearcher = new IndexSearcher(ireader);

			// using multiFieldParser because we have multiple fields for our
			// cake
			// model
			QueryParser parser = new MultiFieldQueryParser(LUCENE_VERSION, new String[] {
					CakeFieldTypes.NAME.getFieldName(), CakeFieldTypes.CATEGORIES.getFieldName(),
					CakeFieldTypes.RECIPE.getFieldName() }, analyzer);

			Query query = parser.parse(queryPhrase);

			ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;

			Map<Long, Long> idScoreMap = new HashMap<Long, Long>(hits.length);
			for (ScoreDoc hit : hits) {
				Document doc = isearcher.doc(hit.doc);

				String id = doc.getField(CakeFieldTypes.ID.getFieldName()).stringValue();
				idScoreMap.put(Long.valueOf(id), new Long((long) (1000 * hit.score)));
			}

			ireader.close();
			directory.close();

			return idScoreMap;

		} catch (IOException e) {
			e.printStackTrace();
			throw new ComplexSearchException("Query failed due to memory issue", e);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ComplexSearchException("Parsing issue. Check indexing/query for invalid symbols. QueyWord = <"
					+ queryPhrase + ">", e);
		}
	}
}
