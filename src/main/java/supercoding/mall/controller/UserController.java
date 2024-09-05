package supercoding.mall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supercoding.mall.domain.Product;
import supercoding.mall.domain.ProductDTO;
import supercoding.mall.domain.UserDTO;
import supercoding.mall.service.UserService;

import java.util.List;

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

    @PostMapping("/add/{id}")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO,@PathVariable String id){
        userService.addProduct(productDTO,id);
        return ResponseEntity.ok("상품 추가 성공");
    }

    @GetMapping("/view")
    public ResponseEntity<List<Product>> viewProducts(){
        List<Product> productList = userService.viewProducts();
        return ResponseEntity.ok(productList);
    }



}
