package supercoding.mall.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import supercoding.mall.domain.User;
import supercoding.mall.domain.SignUpUserDTO;

import java.util.*;

@Repository
@Getter
@RequiredArgsConstructor
public class UserRepository {
    @Getter
    private static List<User> userList = new ArrayList<>();
    private final CartRepository cartRepository;

    public User addUser(int serialId, SignUpUserDTO signUpUserDTO){
        User user = User.builder()
                .id(String.valueOf(serialId))
                .userId(signUpUserDTO.getUserId())
                .name(signUpUserDTO.getName())
                .address(signUpUserDTO.getAddress())
                .phoneNum(signUpUserDTO.getPhoneNum())
                .cart(cartRepository.makeCart(serialId).get(String.valueOf(serialId)))
                .build();
        userList.add(user);
        return user;
    }

    public long findByUserId(String userId){
        return userList.stream().filter(u -> u.getUserId().equals(userId)).count();
    }
    public User findUser(String userId){
        return userList.stream().filter(u -> u.getUserId().equals(userId)).findFirst().get();
    }


}
