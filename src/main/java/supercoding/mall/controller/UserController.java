package supercoding.mall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supercoding.mall.domain.User;
import supercoding.mall.domain.UserDTO;
import supercoding.mall.service.UserService;



@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public User singUp(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

}
