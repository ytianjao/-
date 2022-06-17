package com.yang.ccks2.service.impl;

import com.yang.ccks2.mapper.TextCountMapper;
import com.yang.ccks2.model.TextCount;
import com.yang.ccks2.model.TextCountExample;
import com.yang.ccks2.service.TextCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TextCountServiceImpl implements TextCountService {

    @Autowired
    private TextCountMapper textCountMapper;
    @Override
    public List<TextCount> countTextByName() {
        List<TextCount> textCountList = textCountMapper.selectByExample(new TextCountExample());
//        Map<String, Integer> collect = textCountList.stream().collect(Collectors.toMap(TextCount::getName, TextCount::getValue));
        return textCountList;
    }
}
