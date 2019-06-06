package store;

@SuppressWarnings("serial")
public class NotExistingProductException extends Exception {
   
    public NotExistingProductException(String message){
        super(message);
    }

}
