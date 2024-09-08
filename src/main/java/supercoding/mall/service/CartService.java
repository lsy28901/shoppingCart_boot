package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import supercoding.mall.domain.Product;
import supercoding.mall.repository.CartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public void addToCart(String userId, String productId){
        cartRepository.addToCart(userId,productId);
    }

    public void deleteToCart(String userId,String productId){
        cartRepository.deleteToCart(userId,productId);
    }

    public List<Product> viewMyCart(String userId){
        return cartRepository.getMyCart(userId);
    }
    
    public List<Product> viewMyCartSorted(String userId,String sorted){
        List<Product> productList = cartRepository.getMyCart(userId);
        if (sorted.equals("price")){
            productList = productList.stream().sorted((p1,p2)-> p2.getTotalPrice() - p1.getTotalPrice()).toList();
        }else if (sorted.equals("quantity")){
            productList = productList.stream().sorted((p1,p2)-> p2.getQuantity() - p1.getQuantity()).toList();
        }else if (sorted.equals("name")){
            productList = productList.stream().sorted((p1,p2)->p1.getProductName().compareTo(p2.getProductName())).toList();
        }
        return productList;
    }
    
    public List<Product> viewMyCartFilteredByPrice(String userId,String price){
        return cartRepository.getMyCart(userId).stream().filter(p->p.getTotalPrice() >= Integer.parseInt(price)).toList();
    }

    public List<Product> viewMyCartFilteredByName(String userId,String keyword){
        return cartRepository.getMyCart(userId).stream().filter(p->p.getProductName().contains(keyword)).toList();
    }

    public List<Product> viewMyCartFilteredByCategory(String userId,String category){
        return cartRepository.getMyCart(userId).stream().filter(p->p.getCategory().equals(category)).toList();
    }
}
