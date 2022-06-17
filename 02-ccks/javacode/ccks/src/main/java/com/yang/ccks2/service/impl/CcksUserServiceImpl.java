package com.yang.ccks2.service.impl;

import com.github.pagehelper.PageHelper;
import com.yang.ccks2.mapper.CcksUserMapper;
import com.yang.ccks2.model.CcksUser;
import com.yang.ccks2.model.CcksUserExample;
import com.yang.ccks2.service.CcksUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CcksUserServiceImpl implements CcksUserService {

    @Autowired
    private CcksUserMapper ccksUserMapper;
    @Override
    public int insertCcksUser(CcksUser ccksUser) {
        return ccksUserMapper.insertSelective(ccksUser);
    }

    @Override
    public int deleteCcksUser(Long userId) {
        return ccksUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateCcksUser(Long userId, CcksUser ccksUser) {
        ccksUser.setUserId(userId);
        return ccksUserMapper.updateByPrimaryKeySelective(ccksUser);
    }

    @Override
    public CcksUser selectCcksUserById(Long userId) {
        return ccksUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<CcksUser> findCcksUserList() {
        return ccksUserMapper.selectByExample(new CcksUserExample());
    }

    @Override
    public List<CcksUser> findCcksUserListByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ccksUserMapper.selectByExample(new CcksUserExample());
    }
}
