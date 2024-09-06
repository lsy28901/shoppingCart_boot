package supercoding.mall.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.ProductDTO;
import supercoding.mall.domain.User;
import supercoding.mall.domain.UserDTO;

import java.util.*;

@Repository
@Getter
@RequiredArgsConstructor
public class UserRepository {
    @Getter
    private static Map<String,User> userMap = new HashMap<>();

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

    public long findByUserId(String userId){
        return userMap.entrySet().stream().filter(user->user.getValue().getUserId().equals(userId)).count();
    }


}
