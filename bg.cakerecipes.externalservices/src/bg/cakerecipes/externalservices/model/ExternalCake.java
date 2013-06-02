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
	
	@XmlElement(name="ImageUrl")
	private String imageUrl;

	@XmlElement(name="Rid")
	private String rid;
	
	public ExternalCake() {
		super();
	}

	public ExternalCake(String title, String preparation, String imageUrl) {
		super();
		this.title = title;
		this.preparation = preparation;
		this.imageUrl = imageUrl;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}
	
	public String getRid() {
		return this.rid;
	}
	
	@Override
	public String toString() {
		return "name=" + title + "; recipe=" + preparation + "; imageUrl=" + imageUrl + "\n";
	}
}
