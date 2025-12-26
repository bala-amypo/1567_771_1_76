package com.example.demo.security;

import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    private final Long id;
    private final String username;
    private final String password;
    private final String role;

    private UserPrincipal(Long id,
                          String username,
                          String password,
                          String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // ✅ Factory method used by CustomUserDetailsService
    public static UserPrincipal create(
            Long id,
            String username,
            String password,
            String role) {

        return new UserPrincipal(id, username, password, role);
    }

    // ✅ Used by JwtTokenProvider
    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(
                new SimpleGrantedAuthority("ROLE_" + role)
        );
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // --- Account flags (always true for demo/test use) ---

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
