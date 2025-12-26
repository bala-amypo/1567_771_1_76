package com.example.demo.service;

import com.example.demo.model.RelationshipDeclaration;
import java.util.List;

public interface RelationshipDeclarationService {
    List<RelationshipDeclaration> getAllRelationships();
    RelationshipDeclaration getRelationshipById(Long id);
    RelationshipDeclaration createRelationship(RelationshipDeclaration relationship);
    RelationshipDeclaration updateRelationship(Long id, RelationshipDeclaration relationship);
    void deleteRelationship(Long id);
}
