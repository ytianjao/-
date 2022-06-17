package com.yang.ccks2.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.ccks2.mapper.CcksTextDao;
import com.yang.ccks2.mapper.CcksTextMapper;
import com.yang.ccks2.model.CcksText;
import com.yang.ccks2.model.CcksTextExample;
import com.yang.ccks2.service.CcksTextService;
import com.yang.ccks2.utils.CountResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CcksTextServiceImpl implements CcksTextService {

    @Autowired
    private CcksTextMapper ccksTextMapper;

    @Autowired
    private CcksTextDao ccksTextDao;
    @Override
    public int insertCcksText(CcksText ccksText) {
        return ccksTextMapper.insertSelective(ccksText);
    }

    @Override
    public int deleteCcksText(Long textId) {
        return ccksTextMapper.deleteByPrimaryKey(textId);
    }

    @Override
    public int updateCcksText(Long textId, CcksText ccksText) {
        ccksText.setTextId(textId);
        return ccksTextMapper.updateByPrimaryKeySelective(ccksText);
    }

    @Override
    public CcksText selectCcksTextById(Long textId) {
        return ccksTextMapper.selectByPrimaryKey(textId);
    }

    @Override
    public List<CcksText> findCcksTextList() {
        return ccksTextMapper.selectByExampleWithBLOBs(new CcksTextExample());
    }

    @Override
    public PageInfo findCcksTextListByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
//        Pageable pageable = PageRequest.of(pageNum, pageSize);
        List<CcksText> ccksTextList = ccksTextMapper.selectByExampleWithBLOBs(new CcksTextExample());

        PageInfo pageInfo = new PageInfo<>(ccksTextList);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo findCcksTextListByContentBypage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CcksText> ccksTextListByContentBypage = ccksTextDao.findCcksTextListByContentBypage();
//        System.out.println(ccksTextListByContentBypage);
        PageInfo ccksTextPageInfo = new PageInfo<>(ccksTextListByContentBypage);
        System.out.println(ccksTextPageInfo);
        return ccksTextPageInfo;
//        return new PageInfo();

    }

    @Override
    public List<CountResultMap> countAllByTextName() {

        List<CountResultMap> countResultMapList = ccksTextMapper.countAllByTextName();
        return countResultMapList;
    }


}
