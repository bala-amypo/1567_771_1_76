package com.example.demo.service;

import com.example.demo.model.ConflictFlag;
import java.util.List;

public interface ConflictFlagService {
    List<ConflictFlag> getAllConflictFlags();
    ConflictFlag createConflictFlag(ConflictFlag cf);
    ConflictFlag updateConflictFlag(Long id, ConflictFlag cf);
    void deleteConflictFlag(Long id);
}
