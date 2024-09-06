package supercoding.mall.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.ProductDTO;
import supercoding.mall.domain.User;

import java.util.HashMap;
import java.util.Map;

@Repository
@Getter
@RequiredArgsConstructor
public class ProductRepository {
    private final UserRepository userRepository;

    @Getter
    private static Map<String, Map<String, Product>> productMap = new HashMap<>();

    public void addProduct(int serialId, ProductDTO productDTO, String userId) {
        User findedUser = UserRepository.getUserMap().get(userId);
        Product product = Product.builder()
                .id(String.valueOf(serialId))
                .productName(productDTO.getProductName())
                .userId(findedUser.getUserId())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .totalPrice(productDTO.getPrice() * productDTO.getQuantity())
                .category(productDTO.getCategory().getName()).build();

//        Map<String, Product> innerMap = productMap.computeIfAbsent(findedUser.getUserId(), k -> new HashMap<>());
        Map<String, Product> innerMap = productMap.get(findedUser.getId());
        if (innerMap == null) {
            innerMap = new HashMap<>();
            productMap.put(findedUser.getId(), innerMap);
        }
        innerMap.put(product.getId(), product);
    }

    public Product findProduct(String userId, String productId) {
        User findUser = userRepository.getUserMap().get(userId);
        Map<String, Product> products = productMap.get(findUser.getId());
        return products.get(productId);
    }

    public void deleteProduct(String userId, String productId) {
        productMap.get(userId).remove(productId);
    }
}
