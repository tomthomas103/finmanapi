package com.thoma.finmanapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseEntity {

    @Column(unique = true)
    String username;

    @Column(unique = true)
    String email;

    String password;
    String name;
    String description;
    String preferences;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

}
