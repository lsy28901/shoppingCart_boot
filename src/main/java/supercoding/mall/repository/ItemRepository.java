package supercoding.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supercoding.mall.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
