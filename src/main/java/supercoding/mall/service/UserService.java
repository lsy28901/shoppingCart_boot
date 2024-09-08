package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import supercoding.mall.domain.User;
import supercoding.mall.domain.SignUpUserDTO;
import supercoding.mall.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private static int serialUserId = 1;

    private final UserRepository userRepository;

    public User addUser(SignUpUserDTO signUpUserDTO){
        long alreadyExistId = userRepository.findByUserId(signUpUserDTO.getUserId());
        if (alreadyExistId > 0){
            throw new IllegalArgumentException("해당 아이디의 유저가 존재합니다.");
        }else {
            return userRepository.addUser(serialUserId++, signUpUserDTO);
        }
    }


}
