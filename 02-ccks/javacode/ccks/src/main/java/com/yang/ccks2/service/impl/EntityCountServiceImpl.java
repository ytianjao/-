package com.yang.ccks2.service.impl;

import com.yang.ccks2.mapper.EntityCountMapper;
import com.yang.ccks2.model.EntityCount;
import com.yang.ccks2.model.EntityCountExample;
import com.yang.ccks2.service.EntityCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityCountServiceImpl implements EntityCountService {

    @Autowired
    private EntityCountMapper entityCountMapper;
    @Override
    public List<EntityCount> countAllEntityByTextName(String name) {
        EntityCountExample example = new EntityCountExample();
        EntityCountExample.Criteria criteria = example.createCriteria();
        criteria.andTextNameEqualTo(name);
        List<EntityCount> entityCountList = entityCountMapper.selectByExample(example);
        return entityCountList;
    }

    @Override
    public List<EntityCount> countAllEntity() {
        List<EntityCount> entityCountList = entityCountMapper.selectByExample(new EntityCountExample());
        return entityCountList;
    }
}
