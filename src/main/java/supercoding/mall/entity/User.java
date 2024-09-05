package supercoding.mall.entity;

import jakarta.persistence.*;
import org.springframework.validation.annotation.Validated;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String address;
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    private Cart cart;
}
