package com.yang.ccks2.service.impl;

import com.github.pagehelper.PageHelper;
import com.yang.ccks2.mapper.CcksEntityMapper;
import com.yang.ccks2.model.CcksEntity;
import com.yang.ccks2.model.CcksEntityExample;
import com.yang.ccks2.model.CountResultMap;
import com.yang.ccks2.service.CcksEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CcksEntityServiceImpl implements CcksEntityService {

    @Autowired
    private CcksEntityMapper ccksEntityMapper;
    @Override
    public int insertCcksEntity(CcksEntity ccksEntity) {
        return ccksEntityMapper.insertSelective(ccksEntity);
    }

    @Override
    public int deleteCcksEntity(Long entityId) {
        return ccksEntityMapper.deleteByPrimaryKey(entityId);
    }

    @Override
    public int updateCcksEntity(Long entityId, CcksEntity ccksEntity) {
        return ccksEntityMapper.updateByPrimaryKeySelective(ccksEntity);
    }

    @Override
    public CcksEntity selectCcksEntityById(Long entityId) {
        return ccksEntityMapper.selectByPrimaryKey(entityId);
    }

    @Override
    public List<CcksEntity> findCcksEntityList() {
        return ccksEntityMapper.selectByExample(new CcksEntityExample());
    }

    @Override
    public List<CcksEntity> findCcksEntityListByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ccksEntityMapper.selectByExample(new CcksEntityExample());
    }

    @Override
    public List<CcksEntity> findCcksEntityListByTextId(Long textId) {
        CcksEntityExample ccksEntityExample = new CcksEntityExample();
        ccksEntityExample.createCriteria().andTextIdEqualTo(textId);
        return ccksEntityMapper.selectByExample(ccksEntityExample);
    }

    @Override
    public List<CountResultMap> countAllEntityByEntityName() {
        List<CountResultMap> countResultMapList = ccksEntityMapper.countAllEntityByEntityName();
        return countResultMapList;
    }


}
