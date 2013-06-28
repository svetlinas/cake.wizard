package bg.cakerecipes.webcrawlerservices.crawl.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leni Kirilov
 * 
 */
@XmlRootElement(name="WebCrawlerCake")
@XmlAccessorType(XmlAccessType.FIELD)
public class WebCrawlerCake {

	@XmlElement(name="name")
	private String name;
	
	@XmlElement(name="imageUrl")
	private String imageUrl;
	
	@XmlElement(name="recipe")
	private String recipe;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	
	@Override
	public String toString() {
	   return String.format("Name = %s,  ImageUrl = %s, Recipe = [%s]", name, imageUrl, recipe);
	}
}
