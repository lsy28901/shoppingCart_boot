package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.ProductDTO;
import supercoding.mall.domain.User;
import supercoding.mall.domain.UserDTO;
import supercoding.mall.repository.UserRepository;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private static int serialUserId = 1;
    private static int serialProductId = 1;
    private final UserRepository userRepository;

    public void addUser(UserDTO userDTO){
        long alreadyExistId = userRepository.findByUserId(userDTO.getUserId());
        if (alreadyExistId > 0){
            throw new IllegalArgumentException("해당 아이디의 유저가 존재합니다.");
        }else {
            userRepository.addUser(serialUserId++,userDTO);
        }
    }

    public void addProduct(ProductDTO productDTO,String userId){
        userRepository.addProduct(serialProductId++ , productDTO, userId);
    }

    public void deleteProduct(String userId,String productId){
        userRepository.deleteProduct(userId,productId);
        serialProductId--;
    }

    public Map<String, Map<String, Product>> viewProducts(){
        return userRepository.getProductMap();
    }
}
