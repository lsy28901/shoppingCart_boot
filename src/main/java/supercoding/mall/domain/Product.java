package supercoding.mall.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
    private String id;
    private String productName;
    private int price;
    private int quantity;
    private int totalPrice;
    private String category;

}
