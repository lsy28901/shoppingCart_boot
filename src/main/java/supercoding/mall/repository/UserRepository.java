package supercoding.mall.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.ProductDTO;
import supercoding.mall.domain.User;
import supercoding.mall.domain.UserDTO;

import java.util.*;

@Repository
@Getter
public class UserRepository {

    private Map<String,User> userMap = new HashMap<>();
    private Map<String, Map<String, Product>> productMap = new HashMap<>();

    public void addUser(int serialId,UserDTO userDTO){
        User user = User.builder()
                .id(String.valueOf(serialId))
                .userId(userDTO.getUserId())
                .name(userDTO.getName())
                .address(userDTO.getAddress())
                .phoneNum(userDTO.getPhoneNum())
                .build();
        userMap.put(user.getId(), user);
    }
    public void addProduct(int serialId, ProductDTO productDTO, String userId) {
        User findedUser = userMap.get(userId);
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

    public long findByUserId(String userId){
        return userMap.entrySet().stream().filter(user->user.getValue().getUserId().equals(userId)).count();
    }
    public Product findProduct(String userId, String productId) {
        User findUser = userMap.get(userId);
        Map<String, Product> products = productMap.get(findUser.getId());
        return products.get(productId);
    }

    public void deleteProduct(String userId, String productId) {
        productMap.get(userId).remove(productId);
    }

}
