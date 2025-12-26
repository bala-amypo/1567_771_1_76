package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ConflictFlag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flagName;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFlagName() { return flagName; }
    public void setFlagName(String flagName) { this.flagName = flagName; }
}
