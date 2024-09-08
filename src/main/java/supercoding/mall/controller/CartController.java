package supercoding.mall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supercoding.mall.domain.Product;
import supercoding.mall.service.CartService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/{id}/add")
    public ResponseEntity<String> addToCart(@PathVariable String id, @RequestParam String product_id){
        cartService.addToCart(id,product_id);
        return ResponseEntity.ok("장바구니에 담기 성공");
    }

    @GetMapping({"/{id}/view"})
    public List<Product> viewMyCart(@PathVariable String id){
        return cartService.viewMyCart(id);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<String> deleteToCart(@PathVariable String id,@RequestParam String product_id){
        cartService.deleteToCart(id,product_id);
        return ResponseEntity.ok("장바구니에서 삭제 성공 id:"+product_id);
    }

}
