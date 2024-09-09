package supercoding.mall.exceptions;

public class AlreadyExistProductToCartException extends RuntimeException{

    public AlreadyExistProductToCartException(String message) {
        super(message);
    }
}
