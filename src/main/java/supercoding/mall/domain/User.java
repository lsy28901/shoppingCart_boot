package supercoding.mall.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String id;
    private String userId;
    private String name;
    private String address;
    private String phoneNum;
    private Cart cart;
}
