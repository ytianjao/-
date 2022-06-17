package com.yang.ccks2.service;

import com.yang.ccks2.model.TextCount;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TextCountService {
    List<TextCount> countTextByName();
}
