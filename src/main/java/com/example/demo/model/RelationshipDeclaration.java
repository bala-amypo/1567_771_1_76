package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RelationshipDeclaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long person1Id;
    private Long person2Id;
    private String relationshipType;
    private boolean verified;

    // Default constructor
    public RelationshipDeclaration() {
    }

    // Parameterized constructor
    public RelationshipDeclaration(Long person1Id, Long person2Id, String relationshipType, boolean verified) {
        this.person1Id = person1Id;
        this.person2Id = person2Id;
        this.relationshipType = relationshipType;
        this.verified = verified;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPerson1Id() {
        return person1Id;
    }

    public void setPerson1Id(Long person1Id) {
        this.person1Id = person1Id;
    }

    public Long getPerson2Id() {
        return person2Id;
    }

    public void setPerson2Id(Long person2Id) {
        this.person2Id = person2Id;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
