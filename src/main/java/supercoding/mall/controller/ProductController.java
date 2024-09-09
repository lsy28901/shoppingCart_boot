package supercoding.mall.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "전체 상품 조회", description = "등록된 모든 Product 조회합니다.")
    @GetMapping("/view")
    public ResponseEntity<List<Product>> viewProducts(){
        List<Product> products = productService.viewProducts();
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "상품 등록", description = "하나의 Product 등록합니다.")
    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody AddProductDTO addProductDTO){
        productService.addProduct(addProductDTO);
        return ResponseEntity.ok("상품 추가 성공 "+ addProductDTO.getProductName());
    }

    @Operation(summary = "상품 삭제", description = "등록된 하나의 Product 삭제합니다.")
    @PostMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam String product_id){
        productService.deleteProduct(product_id);
        return ResponseEntity.ok("상품 삭제 성공 상품번호:"+product_id);
    }
}
