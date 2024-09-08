package supercoding.mall.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import supercoding.mall.domain.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CartRepository {

    @Getter
    private static Map<String, List<Product>> cart = new HashMap<>();

    public void addToCart(Product product, List<Product> myCart){
        myCart.add(product);
    }

    public List<Product> getMyCart(String userId){
        return cart.get(userId);
    }

    public void deleteToCart(Product product, List<Product> myCart){
        myCart.remove(product);
    }
}
