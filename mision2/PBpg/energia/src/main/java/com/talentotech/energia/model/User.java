package com.talentotech.energia.model;
import javax.persistence.*;

@Entity
@table(name= "users")
public class User {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private long id;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String email;
}
