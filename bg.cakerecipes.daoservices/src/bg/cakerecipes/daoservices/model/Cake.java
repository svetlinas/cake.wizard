package bg.cakerecipes.daoservices.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Cake")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cake {
	
	@XmlElement(name="id")
	private long id;
	
	@XmlElement(name="name")
	private String name;
	
	@XmlElement(name="products")
	private List<String> products;
	
	@XmlElement(name="recipe")
	private String recipe;
	
	public Cake() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> products) {
		this.products = products;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

}