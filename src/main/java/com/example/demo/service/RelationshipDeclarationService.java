package com.example.demo.service;

import com.example.demo.model.RelationshipDeclaration;
import java.util.List;

public interface RelationshipDeclarationService {
    RelationshipDeclaration createRelationship(RelationshipDeclaration relationship);
    RelationshipDeclaration updateRelationship(Long id, RelationshipDeclaration relationship);
    RelationshipDeclaration getRelationshipById(Long id);
    List<RelationshipDeclaration> getAllRelationships();
}
