package supercoding.mall.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDTO {
    private String userId;
    private String name;
    private String address;
    private String phoneNum;
}
