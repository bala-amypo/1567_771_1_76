package com.example.demo.service;

import com.example.demo.model.ConflictFlag;
import java.util.List;

public interface ConflictFlagService {
    ConflictFlag createConflictFlag(ConflictFlag flag);
    ConflictFlag updateConflictFlag(Long id, ConflictFlag flag);
    ConflictFlag getConflictFlagById(Long id);
    List<ConflictFlag> getAllConflictFlags();
}
