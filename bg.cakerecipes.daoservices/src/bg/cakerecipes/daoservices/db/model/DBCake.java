package bg.cakerecipes.daoservices.db.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CAKES")
@NamedQueries({
		@NamedQuery(name = DBQueryConstants.KEY_getAllCakes, query = DBQueryConstants.QUERY_getAllCakes),
		@NamedQuery(name = DBQueryConstants.KEY_getCakesById, query = DBQueryConstants.QUERY_getCakesById) })
public class DBCake implements IDBCake {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	// TODO we differing models: 1 place categories; 2nd place - ingredients; -
	// let's agree on a merged model of properties
	@Column
	private String ingredients;

	@Column
	private String recipe;

	@Column
	private String imageUrl;

	@ElementCollection()
	private List<String> categories;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	@Override
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
