package supercoding.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supercoding.mall.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
