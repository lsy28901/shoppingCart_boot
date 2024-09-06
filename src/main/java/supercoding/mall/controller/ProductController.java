package supercoding.mall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.ProductDTO;
import supercoding.mall.service.ProductService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/view")
    public ResponseEntity< Map<String, Map<String, Product>>> viewProducts(){
        Map<String, Map<String, Product>> productMap = productService.viewProducts();
        return ResponseEntity.ok(productMap);
    }

    @PostMapping("{id}/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO, @PathVariable String id){
        productService.addProduct(productDTO,id);
        return ResponseEntity.ok("상품 추가 성공 "+productDTO.getProductName());
    }

    @PostMapping("{id}/delete")
    public ResponseEntity<String> deleteProduct(@PathVariable String id,@RequestParam String product_id){
        productService.deleteProduct(id,product_id);
        return ResponseEntity.ok("상품 삭제 성공 상품번호:"+product_id);
    }
}
