package bg.cakerecipes.searchservices.service;

/**
 * A class used to simulate Map because of JAX-B limiations
 * 
 * @author Leni Kirilov
 *
 */
public class Entry {

	private String id;
	private Long rank;

	/**
	 * @return the rank
	 */
	public Long getRank() {
		return rank;
	}

	/**
	 * @param rank
	 *            the rank to set
	 */
	public void setRank(Long rank) {
		this.rank = rank;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
