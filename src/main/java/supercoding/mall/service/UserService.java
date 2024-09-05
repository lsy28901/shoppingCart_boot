package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import supercoding.mall.entity.User;
import supercoding.mall.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signUp(User user){
        userRepository.save(user);
    }

    public User login(String email,String password){
        return userRepository.findByEmailAndPassword(email,password);
    }
}
