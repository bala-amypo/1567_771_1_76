package com.example.demo.service;

import com.example.demo.model.RelationshipDeclaration;
import java.util.List;

public interface RelationshipDeclarationService {
    List<RelationshipDeclaration> getAllRelationships();
    RelationshipDeclaration createRelationship(RelationshipDeclaration rd);
    RelationshipDeclaration updateRelationship(Long id, RelationshipDeclaration rd);
    void deleteRelationship(Long id);
}
