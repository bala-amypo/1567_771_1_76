package com.example.demo.service;

import com.example.demo.model.ConflictFlag;
import java.util.List;

public interface ConflictFlagService {
    List<ConflictFlag> getAllConflictFlags();
    ConflictFlag getConflictFlagById(Long id);
    ConflictFlag createConflictFlag(ConflictFlag conflictFlag);
    ConflictFlag updateConflictFlag(Long id, ConflictFlag conflictFlag);
    void deleteConflictFlag(Long id);
}
