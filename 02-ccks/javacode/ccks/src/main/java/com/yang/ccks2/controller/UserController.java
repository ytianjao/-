package com.yang.ccks2.controller;

import com.yang.ccks2.model.CcksUser;
import com.yang.ccks2.service.CcksUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccksuser")
public class UserController {

    @Autowired
    private CcksUserService ccksUserService;
    @GetMapping("/")
    public String test(){
        return "test";
    }

    @PostMapping("/add")
    public String addCcksUser(@RequestBody CcksUser ccksUser){
        int i = ccksUserService.insertCcksUser(ccksUser);
        if (i != 0){
            return "success";
        }else {
            return "false";
        }
    }

    @DeleteMapping("/delete/{userid}")
    public String deleteCcksUser(@PathVariable("userid") Long userId){
        int i = ccksUserService.deleteCcksUser(userId);
        if (i != 0){
            return "success";
        }else {
            return "false";
        }
    }

    @PostMapping("/update/{id}")
    public String updateCcksUser(@PathVariable("id") Long id, @RequestBody CcksUser ccksUser){
        int i = ccksUserService.updateCcksUser(id, ccksUser);
        if (i != 0){
            return "success";
        }else {
            return "false";
        }
    }

    @GetMapping("/select/{id}")
    public CcksUser selectCcksUser(@PathVariable("id") Long id){
        CcksUser ccksUser = ccksUserService.selectCcksUserById(id);
        return ccksUser;
    }

    @GetMapping("/findall")
    public List<CcksUser> findAllCcksUser(){
        List<CcksUser> ccksUserList = ccksUserService.findCcksUserList();
        return ccksUserList;
    }

    @GetMapping("/findallbypage")
    public List<CcksUser> findAllCcksUserByPage(@RequestParam int pageNum, @RequestParam int pageSize){
        List<CcksUser> ccksUserListByPage = ccksUserService.findCcksUserListByPage(pageNum, pageSize);
        return ccksUserListByPage;
    }
}
