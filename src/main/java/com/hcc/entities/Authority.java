package com.hcc.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Not positive it's supposed to implement UserDetails...
 */
@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority")
    private String authority;
    @ManyToOne(optional = false) //partial replacement for @Column
    private User user;

    public Authority(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }
    public Authority(String authority) {
        this.authority = authority;
    }
    public Authority() {}

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(targetEntity = User.class)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
