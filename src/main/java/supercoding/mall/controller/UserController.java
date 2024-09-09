package supercoding.mall.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supercoding.mall.domain.User;
import supercoding.mall.domain.SignUpUserDTO;
import supercoding.mall.service.UserService;



@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입",description = "유저를 생성합니다.")
    @PostMapping("/signup")
    public ResponseEntity<String> singUp(@RequestBody SignUpUserDTO signUpUserDTO){
        User newUser = userService.addUser(signUpUserDTO);
        return ResponseEntity.ok(newUser.getName()+"유저 추가 성공");
    }

}
