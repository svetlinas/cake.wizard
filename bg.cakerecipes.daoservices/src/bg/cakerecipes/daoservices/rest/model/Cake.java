package bg.cakerecipes.daoservices.rest.model;

import java.util.Arrays;
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
	
	//TODO remove this ! later on
	@XmlElement(name="ingredients")
	private String ingredients;
	
	@XmlElement(name="recipe")
	private String recipe;
	
	@XmlElement(name="imageUrl")
	private String imageUrl;

	@XmlElement(name="categories")
	private List<String> categories;

	@Override
	public String toString() {
		if(this.categories!=null) {
			return String.format("name=%s; id=%d ; ingredients= %s, categories= %s ; recipe=%s; imageUrl= %s", 
					this.name, this.id, this.ingredients, Arrays.deepToString(this.categories.toArray()), this.recipe, this.imageUrl);
		}
		return String.format("name=%s; id=%d ; ingredients= %s, categories= %s ; recipe=%s; imageUrl= %s", 
				this.name, this.id, this.ingredients, null, this.recipe, this.imageUrl);
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

}