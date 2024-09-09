package supercoding.mall.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddProductDTO {
    private String productName;
    private int price;
    private int quantity;
    private Category category;
}
