package supercoding.mall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.AddProductDTO;
import supercoding.mall.repository.ProductRepository;
import supercoding.mall.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

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
        Optional<Product> findProduct = productRepository.findProduct(productId);

        if (findProduct.isPresent()){
            productRepository.deleteProduct(productId);
            serialProductId--;
        }else {
            throw new NotFoundException("삭제할 상품이 존재하지 않습니다.");
        }
    }

    public List<Product> viewProducts(){
        return ProductRepository.getProductList();
    }
}
