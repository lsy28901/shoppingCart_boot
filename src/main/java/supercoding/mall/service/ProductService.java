package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.AddProductDTO;
import supercoding.mall.repository.ProductRepository;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    private static int serialProductId = 1;
    public void addProduct(AddProductDTO addProductDTO){
        productRepository.addProduct(serialProductId++ , addProductDTO);
    }

    public void deleteProduct(String productId){
        productRepository.deleteProduct(productId);
        serialProductId--;
    }

    public List<Product> viewProducts(){
        return ProductRepository.getProductList();
    }
}
