package supercoding.mall.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class ProductDTO {
    private String productName;
    private int price;
    private int quantity;
    private Category category;

}
