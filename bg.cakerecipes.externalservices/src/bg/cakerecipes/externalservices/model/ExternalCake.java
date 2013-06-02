package bg.cakerecipes.externalservices.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RetrievedCake")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExternalCake {
	
	@XmlElement(name="Rid")
	private String rid;
	
	@XmlElement(name="Data")
	private List<String> data;

	@XmlElement(name="Title")
	private Double title;
	
	@XmlElement(name="Online")
	private String online;

	@XmlElement(name="Preparation")
	private String preparation;
	
	@XmlElement(name="Views")
	private String views;
	
	@XmlElement(name="Votes")
	private String votes;
	
	
	@XmlElement(name="Rating")
	private String rating;
	
	@XmlElement(name="Category")
	private String category;
	
	@XmlElement(name="Link")
	private String link;
	
	@XmlElement(name="Stars")
	private String stars;
	
	@XmlElement(name="edit")
	private String edit;

	
	public ExternalCake() {
		super();
	}
	
	public ExternalCake(String rid, List<String> data, Double title, String online, String preparation, String views,
			String votes, String rating, String category, String link, String stars, String edit) {
		super();
		this.rid = rid;
		this.data = data;
		this.title = title;
		this.online = online;
		this.preparation = preparation;
		this.views = views;
		this.votes = votes;
		this.rating = rating;
		this.category = category;
		this.link = link;
		this.stars = stars;
		this.edit = edit;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	public Double getTitle() {
		return title;
	}

	public void setTitle(Double title) {
		this.title = title;
	}

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

	public String getPreparation() {
		return preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public String getVotes() {
		return votes;
	}

	public void setVotes(String votes) {
		this.votes = votes;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

}
