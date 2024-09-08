package supercoding.mall.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import supercoding.mall.domain.User;

import java.util.*;

@Repository
@Getter
@RequiredArgsConstructor
public class UserRepository {
    @Getter
    private static List<User> userList = new ArrayList<>();

    public User addUser(User user){
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
