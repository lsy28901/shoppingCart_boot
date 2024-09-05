package supercoding.mall.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {
    private final List<Product> cartList = new ArrayList<>();
}
