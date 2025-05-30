package com.scaler.ecommerce.representingInheritance.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "jt_user")
public class User {
    @Id
    @PrimaryKeyJoinColumn(name = "user_id")
    private Long id;
    private String name;
    private String email;
    private String password;

}
