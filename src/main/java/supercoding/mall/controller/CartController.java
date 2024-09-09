package supercoding.mall.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "장바구니에 추가", description = "내 장바구니에 하나의 Product 추가합니다.")
    @PostMapping("/{id}/add")
    public String addToCart(@PathVariable String id, @RequestParam String product_id){
        cartService.addToCart(id,product_id);
        return "장바구니에 담기 성공";
    }

    @Operation(summary = "장바구니에서 삭제", description = "내 장바구니에서 하나의 Product 삭제합니다.")
    @PostMapping("/{id}/delete")
    public String deleteToCart(@PathVariable String id,@RequestParam String product_id){
        cartService.deleteToCart(id,product_id);
        return "장바구니에서 삭제 성공";
    }

    @Operation(summary = "장바구니 조회", description = "내 장바구니를 조회합니다.")
    @GetMapping("/{id}/view")
    public List<Product> viewMyCart(@PathVariable String id){
        return cartService.viewMyCart(id);
    }

    @Operation(summary = "장바구니 정렬", description = "장바구니를 sorted 파라미터 값에 따라 정렬합니다.")
    @GetMapping("/{id}/view/sort")
    public List<Product> viewMyCartSorted(@PathVariable String id,@RequestParam String sorted){
        return cartService.viewMyCartSorted(id,sorted);
    }

    @Operation(summary = "장바구니 가격 필터", description = "장바구니 안의 price 파라미터 값 이상인 Product 조회")
    @GetMapping("/{id}/view/filter/price")
    public List<Product> viewMyCartFilteredByPrice(@PathVariable String id, @RequestParam String price){
        return cartService.viewMyCartFilteredByPrice(id,price);
    }

    @Operation(summary = "장바구니 이름 필터", description = "장바구니 안의 name 파라미터 값을 이름안에 포함하는 Product 조회")
    @GetMapping("/{id}/view/filter/name")
    public List<Product> viewMyCartFilteredByName(@PathVariable String id,@RequestParam String keyword){
        return cartService.viewMyCartFilteredByName(id,keyword);
    }

    @Operation(summary = "장바구니 카테고리 필터", description = "장바구니 안의 category 파라미터 값에 따른 Product 조회")
    @GetMapping("/{id}/view/filter/category")
    public List<Product> viewMyCartFilteredByCategory(@PathVariable String id,@RequestParam String category){
        return cartService.viewMyCartFilteredByCategory(id,category);
    }

}
