package com.yang.ccks2.service;

import com.github.pagehelper.PageInfo;
import com.yang.ccks2.model.CcksText;
import com.yang.ccks2.utils.CountResultMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CcksTextService {
    int insertCcksText(CcksText ccksText);

    int deleteCcksText(Long textId);

    int updateCcksText(Long textId, CcksText ccksText);

    CcksText selectCcksTextById(Long textId);

    List<CcksText> findCcksTextList();

    PageInfo findCcksTextListByPage(int pageNum, int pageSize);


    PageInfo findCcksTextListByContentBypage(int pageNum, int pageSize);

    List<CountResultMap>  countAllByTextName();
}
