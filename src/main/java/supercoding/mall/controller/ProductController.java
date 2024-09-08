package supercoding.mall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.AddProductDTO;
import supercoding.mall.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/view")
    public ResponseEntity<List<Product>> viewProducts(){
        List<Product> products = productService.viewProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody AddProductDTO addProductDTO){
        productService.addProduct(addProductDTO);
        return ResponseEntity.ok("상품 추가 성공 "+ addProductDTO.getProductName());
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam String product_id){
        productService.deleteProduct(product_id);
        return ResponseEntity.ok("상품 삭제 성공 상품번호:"+product_id);
    }
}
