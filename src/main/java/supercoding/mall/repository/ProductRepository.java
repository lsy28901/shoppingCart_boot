package supercoding.mall.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.AddProductDTO;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@RequiredArgsConstructor
public class ProductRepository {

    @Getter
    private static List<Product> productList = new ArrayList<>();

    public void addProduct(int serialId, AddProductDTO addProductDTO) {
        Product product = Product.builder()
                .id(String.valueOf(serialId))
                .productName(addProductDTO.getProductName())
                .price(addProductDTO.getPrice())
                .quantity(addProductDTO.getQuantity())
                .totalPrice(addProductDTO.getPrice() * addProductDTO.getQuantity())
                .category(addProductDTO.getCategory().getName()).build();
        productList.add(product);
    }

    public Product findProduct(String productId) {
        return productList.stream().filter(p->p.getId().equals(productId)).findFirst().get();
    }

    public void deleteProduct(String productId) {
        productList.remove(findProduct(productId));
    }
}
