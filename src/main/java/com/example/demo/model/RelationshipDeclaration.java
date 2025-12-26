package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RelationshipDeclaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean verified;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isVerified() { return verified; }
    public void setVerified(boolean verified) { this.verified = verified; }
}
