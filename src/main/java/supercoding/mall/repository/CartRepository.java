package supercoding.mall.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import supercoding.mall.domain.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CartRepository {

    private static Map<String, List<Product>> cart = new HashMap<>();
    private final ProductRepository productRepository;

    public Map<String,List<Product>> makeCart(int id){
        cart.put(String.valueOf(id),new ArrayList<>());
        return cart;
    }

    public void addToCart(String userId,String productId){
        Product findProduct = productRepository.findProduct(productId);
        List<Product> myCart = cart.get(userId);
        myCart.add(findProduct);
    }

    public List<Product> getMyCart(String userId){
        return cart.get(userId);
    }

    public void deleteToCart(String userId, String productId){
        Product findedProduct = productRepository.findProduct(productId);
        cart.get(userId).remove(findedProduct);
    }
}
