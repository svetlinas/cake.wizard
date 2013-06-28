package bg.cakerecipes.searchservices.engine.lucene;

/**
 * Marks search exceptions
 * 
 * @author Leni Kirilov
 * 
 */
public class ComplexSearchException extends RuntimeException {

   public ComplexSearchException() {
   	super();
   }
   
   public ComplexSearchException(String message, Throwable cause){
   	super(message, cause);
   }
}
