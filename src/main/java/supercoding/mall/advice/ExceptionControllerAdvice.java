package supercoding.mall.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import supercoding.mall.exceptions.AlreadyExistProductToCartException;
import supercoding.mall.exceptions.AlreadyExistUserException;
import supercoding.mall.exceptions.NotFoundException;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException e){
        log.error("Client 가 요청한 데이터가 존재하지 않습니다. message={}", e.getMessage());
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AlreadyExistUserException.class)
    public String handleAlreadyExistUserException(AlreadyExistUserException e){
        log.error("Client 가 요청한 회원 데이터가 이미 존재합니다. message={}",e.getMessage());
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AlreadyExistProductToCartException.class)
    public String handleAlreadyExistProductToCartException(AlreadyExistProductToCartException e){
        log.error("Client 가 요청한 상품 데이터가 장바구니에 이미 존재합니다. message={}",e.getMessage());
        return e.getMessage();
    }

}
