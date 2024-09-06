package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import supercoding.mall.domain.UserDTO;
import supercoding.mall.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private static int serialUserId = 1;

    private final UserRepository userRepository;

    public void addUser(UserDTO userDTO){
        long alreadyExistId = userRepository.findByUserId(userDTO.getUserId());
        if (alreadyExistId > 0){
            throw new IllegalArgumentException("해당 아이디의 유저가 존재합니다.");
        }else {
            userRepository.addUser(serialUserId++,userDTO);
        }
    }


}
