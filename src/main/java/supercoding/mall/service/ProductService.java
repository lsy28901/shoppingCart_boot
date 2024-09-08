package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.AddProductDTO;
import supercoding.mall.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    private static int serialProductId = 1;
    public void addProduct(AddProductDTO addProductDTO){
        Product product = Product.builder()
                .id(String.valueOf(serialProductId++))
                .productName(addProductDTO.getProductName())
                .price(addProductDTO.getPrice())
                .quantity(addProductDTO.getQuantity())
                .totalPrice(addProductDTO.getPrice() * addProductDTO.getQuantity())
                .category(addProductDTO.getCategory().getName()).build();
        productRepository.addProduct(product);
    }

    public void deleteProduct(String productId){
        productRepository.deleteProduct(productId);
        serialProductId--;
    }

    public List<Product> viewProducts(){
        return ProductRepository.getProductList();
    }
}
