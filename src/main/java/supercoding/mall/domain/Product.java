package supercoding.mall.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {
    private String productName;
    private String userId;
    private int price;
    private int quantity;
    private int totalPrice;
    private String category;

}
