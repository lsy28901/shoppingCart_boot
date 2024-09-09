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

    @PostMapping("/{id}/delete")
    public ResponseEntity<String> deleteToCart(@PathVariable String id,@RequestParam String product_id){
        cartService.deleteToCart(id,product_id);
        return ResponseEntity.ok("장바구니에서 삭제 성공 id:"+product_id);
    }

    @GetMapping("/{id}/view")
    public List<Product> viewMyCart(@PathVariable String id){
        return cartService.viewMyCart(id);
    }

    @GetMapping("/{id}/view/sort")
    public List<Product> viewMyCartSorted(@PathVariable String id,@RequestParam String sorted){
        return cartService.viewMyCartSorted(id,sorted);
    }

    @GetMapping("/{id}/view/filter/price")
    public List<Product> viewMyCartFilteredByPrice(@PathVariable String id, @RequestParam String price){
        return cartService.viewMyCartFilteredByPrice(id,price);
    }

    @GetMapping("/{id}/view/filter/name")
    public List<Product> viewMyCartFilteredByName(@PathVariable String id,@RequestParam String keyword){
        return cartService.viewMyCartFilteredByName(id,keyword);
    }

    @GetMapping("/{id}/view/filter/category")
    public List<Product> viewMyCartFilteredByCategory(@PathVariable String id,@RequestParam String category){
        return cartService.viewMyCartFilteredByCategory(id,category);
    }

}
