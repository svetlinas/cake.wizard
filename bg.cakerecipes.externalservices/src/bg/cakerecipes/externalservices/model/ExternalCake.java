package bg.cakerecipes.externalservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ExternalCake")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExternalCake {
	
	@XmlElement(name="Title")
	private String title;
	
	@XmlElement(name="Preparation")
	private String preparation;
	
	@XmlElement(name="Category")
	private String category;
	
	public ExternalCake() {
		super();
	}

	public ExternalCake(String title, String preparation, String category) {
		super();
		this.title = title;
		this.preparation = preparation;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPreparation() {
		return preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ExternalCake [title=" + title + ", preparation=" + preparation + ", category=" + category + "]";
	}
	
}
