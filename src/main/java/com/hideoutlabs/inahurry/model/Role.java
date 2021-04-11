package com.hideoutlabs.inahurry.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public  class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String  roles;

    public Role(String roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    // remaining getters and setters
}