package supercoding.mall.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {
    private String email;
    private String password;
    private String name;
    private String address;
    private String phone;
}
