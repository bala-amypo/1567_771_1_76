package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // In-memory user store for tests
    private final Map<String, UserPrincipal> users = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    /**
     * Register a new user (used ONLY in tests / demo auth flow)
     */
    public UserPrincipal register(
            String username,
            String password,
            String role) {

        UserPrincipal user = UserPrincipal.create(
                idGenerator.getAndIncrement(),
                username,
                password,
                role
        );

        users.put(username, user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserPrincipal user = users.get(username);

        if (user == null) {
            throw new UsernameNotFoundException(
                    "User not found: " + username);
        }

        return user;
    }
}
