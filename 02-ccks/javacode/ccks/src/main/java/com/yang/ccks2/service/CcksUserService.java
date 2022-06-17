package com.yang.ccks2.service;

import com.yang.ccks2.model.CcksUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CcksUserService {
    int insertCcksUser(CcksUser ccksUser);
    int deleteCcksUser(Long userId);
    int updateCcksUser(Long userId, CcksUser ccksUser);
    CcksUser selectCcksUserById(Long userId);

    List<CcksUser> findCcksUserList();
    List<CcksUser> findCcksUserListByPage(int pageNum, int pageSize);

}
