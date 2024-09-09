package supercoding.mall.exceptions;

import org.springframework.http.HttpStatusCode;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
