package com.yang.ccks2.service;

import com.yang.ccks2.model.EntityCount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntityCountService {
    List<EntityCount> countAllEntityByTextName(String name);
    List<EntityCount> countAllEntity();

}
