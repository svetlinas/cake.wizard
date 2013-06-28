package bg.cakerecipes.webcrawlerservices.crawl.model;

/**
 * @author Leni Kirilov
 * 
 */
public class Cake {

	private String name;
	private String imageUrl;
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
	   return String.format("Name= %s,  ImageUrl= %s, Recipe= [%s]", name, imageUrl, recipe);
	}
}
