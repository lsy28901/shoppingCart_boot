package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.User;
import supercoding.mall.domain.SignUpUserDTO;
import supercoding.mall.repository.CartRepository;
import supercoding.mall.repository.UserRepository;
import supercoding.mall.exceptions.AlreadyExistUserException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private static int serialUserId = 1;

    private final UserRepository userRepository;

    public User addUser(SignUpUserDTO signUpUserDTO){

        User user = User.builder()
                .id(String.valueOf(serialUserId))
                .userId(signUpUserDTO.getUserId())
                .name(signUpUserDTO.getName())
                .address(signUpUserDTO.getAddress())
                .phoneNum(signUpUserDTO.getPhoneNum())
                .cart(CartRepository.getCart().put(String.valueOf(serialUserId),new ArrayList<>()))
                .build();

        long alreadyExistId = userRepository.findByUserId(signUpUserDTO.getUserId());
        if (alreadyExistId > 0){
            throw new AlreadyExistUserException("해당 아이디의 유저가 존재합니다.");
        }else {
            serialUserId++;
            return userRepository.addUser(user);
        }
    }

}




