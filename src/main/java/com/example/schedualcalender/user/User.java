package com.example.schedualcalender.user;

import javax.persistence.*;

@Entity
@Table(name =  "tbl_USER")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
