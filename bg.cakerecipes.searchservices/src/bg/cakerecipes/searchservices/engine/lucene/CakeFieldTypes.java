package bg.cakerecipes.searchservices.engine.lucene;

/**
 * @author Leni Kirilov
 * 
 */
public enum CakeFieldTypes {

	NAME("name"), CATEGORIES("categories"), RECIPE("recipe"), ID("id");

	private String fieldName;

	private CakeFieldTypes(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldName() {
	   return fieldName;
   }

	public void setFieldName(String fieldName) {
	   this.fieldName = fieldName;
   }

}
