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

    public void addUser(UserDTO userDTO){
        User user = User.builder()
                .userId(userDTO.getUserId())
                .name(userDTO.getName())
                .address(userDTO.getAddress())
                .phoneNum(userDTO.getPhoneNum())
                .build();
        userMap.put(user.getUserId(), user);
    }
    public void addProduct(ProductDTO productDTO, String userId) {
        User findedUser = userMap.get(userId);
        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .userId(findedUser.getUserId())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .totalPrice(productDTO.getPrice() * productDTO.getQuantity())
                .category(productDTO.getCategory().getName()).build();

        Map<String, Product> innerMap = productMap.computeIfAbsent(findedUser.getUserId(), k -> new HashMap<>());

        innerMap.put(product.getProductName(), product);
    }


    public User findUser(String id){
        return userMap.get(id);
    }
    public Product findProduct(String userId, String productName) {
        User findUser = findUser(userId);
        Map<String, Product> products = productMap.get(findUser.getUserId());
        return products.get(productName);
    }

    public void deleteProduct(String userId, String productName) {
        productMap.get(userId).remove(productName);
    }



}
