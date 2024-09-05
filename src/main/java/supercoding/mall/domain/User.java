package supercoding.mall.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Builder
public class User {
    private final String userId;
    private String name;
    private String address;
    private String phoneNum;

    private Cart cart = new Cart();
    private final List<Product> myCart = cart.getCartList();

}
