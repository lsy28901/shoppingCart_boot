package supercoding.mall.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class User {
    private String id;
    private String userId;
    private String name;
    private String address;
    private String phoneNum;
    private List<Product> cart;
}
