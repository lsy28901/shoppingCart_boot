package supercoding.mall.service;

import org.springframework.stereotype.Service;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.ProductDTO;
import supercoding.mall.domain.User;
import supercoding.mall.domain.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    List<User> userList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();

    public void addUser(UserDTO userDTO){
        User user = User.builder()
                .userId(userDTO.getUserId())
                .name(userDTO.getName())
                .address(userDTO.getAddress())
                .phoneNum(userDTO.getPhoneNum())
                .build();
        userList.add(user);
    }

    public User findUser(String id){
        Optional<User> findUser =userList.stream().filter(user -> user.getUserId().equals(id)).findFirst();
        return findUser.get();
    }

    public void addProduct(ProductDTO productDTO,String id){
        User findedUser = findUser(id);
        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .userId(findedUser.getUserId())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .totalPrice(productDTO.getPrice() * productDTO.getQuantity())
                .category(productDTO.getCategory().getName()).build();
        productList.add(product);
    }

    public List<Product> viewProducts(){
        return productList;
    }
}
