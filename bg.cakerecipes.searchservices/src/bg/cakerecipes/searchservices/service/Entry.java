package bg.cakerecipes.searchservices.service;

/**
 * A class used to simulate Map because of JAX-B limitations
 * 
 * @author Leni Kirilov
 * 
 */
public class Entry {

	private Long id;
	private Long rank;

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
