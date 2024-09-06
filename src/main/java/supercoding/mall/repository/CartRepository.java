package supercoding.mall.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import supercoding.mall.domain.Product;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CartRepository {

    Map<String,Map<String, Product>> cart = new HashMap<>();

    public Map<String,Map<String, Product>> makeCart(int id){
        cart.put(String.valueOf(id),null);
        return cart;
    }
}
