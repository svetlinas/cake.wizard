package bg.cakerecipes.drservices.dr.model;

import java.util.Arrays;
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
	
	@XmlElement(name="recipe")
	private String recipe;

	@XmlElement(name="imageUrl")
	private String imageUrl;
	
	public RetrievedCake() {
		super();
	}
	
	public RetrievedCake(String name, List<String> categories, Double price, String recipe, String imageUrl) {
		super();
		this.name = name;
		this.categories = categories;
		this.price = price;
		this.recipe = recipe;
		this.imageUrl = imageUrl;
	}
	
	@Override
	public String toString() {
		return String.format("name=%s ; price=%f; recipe= < %s > ; categories= %s ; imageUrl = %s", 
				this.name, this.price, this.recipe, Arrays.deepToString(this.categories.toArray()), this.imageUrl);
		
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

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
