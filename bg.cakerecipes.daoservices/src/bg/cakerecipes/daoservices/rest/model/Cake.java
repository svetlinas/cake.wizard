package bg.cakerecipes.daoservices.rest.model;

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
	
	@XmlElement(name="ingredients")
	private String ingredients;
	
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

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

}