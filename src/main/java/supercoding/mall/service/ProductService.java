package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.ProductDTO;
import supercoding.mall.repository.ProductRepository;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    private static int serialProductId = 1;
    public void addProduct(ProductDTO productDTO, String userId){
        productRepository.addProduct(serialProductId++ , productDTO, userId);
    }

    public void deleteProduct(String userId,String productId){
        productRepository.deleteProduct(userId,productId);
        serialProductId--;
    }

    public Map<String, Map<String, Product>> viewProducts(){
        return ProductRepository.getProductMap();
    }
}
