package supercoding.mall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.ProductDTO;
import supercoding.mall.domain.UserDTO;
import supercoding.mall.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> singUp(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("{id}/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO,@PathVariable String id){
        userService.addProduct(productDTO,id);
        return ResponseEntity.ok("상품 추가 성공");
    }

    @GetMapping("/view")
    public ResponseEntity< Map<String, Map<String, Product>>> viewProducts(){
        Map<String, Map<String, Product>> productMap = userService.viewProducts();
        return ResponseEntity.ok(productMap);
    }

    @PostMapping("{id}/delete")
    public ResponseEntity<String> deleteProduct(@PathVariable String id,@RequestParam String product_name){
        userService.deleteProduct(id,product_name);
        return ResponseEntity.ok("상품 삭제 성공");
    }


}
