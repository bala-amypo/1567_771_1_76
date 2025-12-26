package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class PersonProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean relationshipDeclared;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isRelationshipDeclared() { return relationshipDeclared; }
    public void setRelationshipDeclared(boolean relationshipDeclared) { this.relationshipDeclared = relationshipDeclared; }
}
