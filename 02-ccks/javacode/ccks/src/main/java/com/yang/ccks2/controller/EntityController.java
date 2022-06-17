package com.yang.ccks2.controller;

import com.yang.ccks2.mapper.CcksEntityMapper;
import com.yang.ccks2.model.CcksEntity;
import com.yang.ccks2.model.CcksText;
import com.yang.ccks2.service.CcksEntityService;
import com.yang.ccks2.service.CcksTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ccksentity")
public class EntityController {

    @Autowired
    private CcksEntityService ccksEntityService;
    @Autowired
    private CcksTextService ccksTextService;
    @PostMapping("/add")
    public String addCcksEntity(@RequestBody CcksEntity ccksEntity){
//        ccksEntity.setTextId(textid);
        int i = ccksEntityService.insertCcksEntity(ccksEntity);
        if (i != 0) {
            return "success";
        } else {
            return "false";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCcksEntity(@PathVariable("id") Long id){
        int i = ccksEntityService.deleteCcksEntity(id);
        if (i != 0) {
            return "success";
        } else {
            return "false";
        }
    }

    @PostMapping("/update/{id}")
    public String updateCcksEntity(@PathVariable("id") Long id, @RequestBody CcksEntity ccksEntity){
        int i = ccksEntityService.updateCcksEntity(id, ccksEntity);
        if (i != 0) {
            return "success";
        } else {
            return "false";
        }
    }

//    @GetMapping("/find/{id}")
//    public List<CcksEntity> findAllCcksEntityById(@PathVariable("id") Long id){
//        List<CcksEntity> ccksEntityListById = ccksEntityService.findCcksEntityListById(id);
//        return ccksEntityListById;
//    }
    @GetMapping("/fingbytextid")
    public List<CcksEntity> findCcksEntityByTextId(@RequestParam(value = "textId", defaultValue = "7") Long textId){
        List<CcksEntity> ccksEntityListByTextId = ccksEntityService.findCcksEntityListByTextId(textId);
        return ccksEntityListByTextId;
    }
}
