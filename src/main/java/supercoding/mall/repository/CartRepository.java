package supercoding.mall.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import supercoding.mall.domain.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
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

    public Optional<Product> findProductToCart(String userId,String productId){
        Optional<Product> product = CartRepository.getCart().get(userId)
                .stream().filter(p->p.getId().equals(productId)).findFirst();

        return product;
    }
}
