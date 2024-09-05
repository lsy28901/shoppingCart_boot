package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.ProductDTO;
import supercoding.mall.domain.User;
import supercoding.mall.domain.UserDTO;
import supercoding.mall.repository.UserRepository;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void addUser(UserDTO userDTO){
        userRepository.addUser(userDTO);
    }

    public void addProduct(ProductDTO productDTO,String id){
        userRepository.addProduct(productDTO, id);
    }

    public void deleteProduct(String userId,String productName){
        userRepository.deleteProduct(userId,productName);
    }

    public Map<String, Map<String, Product>> viewProducts(){
        return userRepository.getProductMap();
    }
}
