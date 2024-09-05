package supercoding.mall.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supercoding.mall.entity.Cart;
import supercoding.mall.entity.User;
import supercoding.mall.entity.UserDTO;
import supercoding.mall.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestParam UserDTO userDTO){
        User user = User.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .address(userDTO.getAddress())
                .phone(userDTO.getPhone())
                .cart(new Cart()).build();

        userService.signUp(user);

        return ResponseEntity.ok("회원가입 성공");
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(String email, String password, HttpSession session){
        User findUser = userService.login(email,password);
        long myId = findUser.getId();
        session.setAttribute("userId",myId);
        return ResponseEntity.ok("로그인 성공, ID:"+ myId);
    }

}
