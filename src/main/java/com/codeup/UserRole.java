package com.codeup;

import javax.persistence.*;

/**
 * Created by Austin on 1/11/17.
 */

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "role")
    private String role;


}
