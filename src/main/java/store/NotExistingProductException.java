package store;

@SuppressWarnings("serial")
public class NotExistingProductException extends Exception {
    NotExistingProductException(){
        super();
    }

    public NotExistingProductException(String message){
        super(message);
    }

}
