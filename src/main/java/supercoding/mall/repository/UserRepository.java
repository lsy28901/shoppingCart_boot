package supercoding.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supercoding.mall.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailAndPassword(String email,String password);
}
