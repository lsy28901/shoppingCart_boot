package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import supercoding.mall.domain.Product;
import supercoding.mall.repository.CartRepository;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public void addToCart(String userId, String productId){
        cartRepository.addToCart(userId,productId);
    }

    public List<Product> viewMyCart(String userId){
        return cartRepository.viewMyCart(userId);
    }

    public void deleteToCart(String userId,String productId){
        cartRepository.deleteToCart(userId,productId);
    }
}
