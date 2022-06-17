package com.yang.ccks2.service;

import com.yang.ccks2.model.CcksEntity;
import com.yang.ccks2.model.CcksText;
import com.yang.ccks2.model.CountResultMap;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CcksEntityService {
    int insertCcksEntity(CcksEntity ccksEntity);

    int deleteCcksEntity(Long entityId);

    int updateCcksEntity(Long entityId, CcksEntity ccksEntity);

    CcksEntity selectCcksEntityById(Long entityId);

    List<CcksEntity> findCcksEntityList();

    List<CcksEntity> findCcksEntityListByPage(int pageNum, int pageSize);
    List<CcksEntity> findCcksEntityListByTextId(Long textId);
    List<CountResultMap> countAllEntityByEntityName();
}
