package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import supercoding.mall.domain.Product;
import supercoding.mall.exceptions.NotFoundException;
import supercoding.mall.repository.CartRepository;
import supercoding.mall.repository.ProductRepository;
import supercoding.mall.exceptions.AlreadyExistProductToCartException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public void addToCart(String userId, String productId){
        Optional<Product> findProduct = productRepository.findProduct(productId);
        List<Product> myCart = cartRepository.getMyCart(userId);

        Optional<Product> findProductToCart = cartRepository.findProductToCart(userId,productId);
        if (findProductToCart.isEmpty()){
            cartRepository.addToCart(findProduct.get() ,myCart);
        }else {
            throw new AlreadyExistProductToCartException("장바구니에 해당 상품이 이미 존재합니다");
        }

    }

    public void deleteToCart(String userId,String productId){
        List<Product> myCart = cartRepository.getMyCart(userId);
        Optional<Product> findProductToCart = cartRepository.findProductToCart(userId,productId);

        if (findProductToCart.isPresent()){
            cartRepository.deleteToCart(findProductToCart.get() ,myCart);
        }else {
            throw new NotFoundException("장바구니에 해당 상품이 없음");
        }
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
