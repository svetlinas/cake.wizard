package bg.cakerecipes.drservices.dr.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RetrievedCake")
@XmlAccessorType(XmlAccessType.FIELD)
public class RetrievedCake {

	@XmlElement(name="name")
	private String name;
	
	@XmlElement(name="categories")
	private List<String> categories;

	@XmlElement(name="price")
	private Double price;

	public RetrievedCake() {
		super();
	}

	
	public RetrievedCake(String name, List<String> categories, Double price) {
		super();
		this.name = name;
		this.categories = categories;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
