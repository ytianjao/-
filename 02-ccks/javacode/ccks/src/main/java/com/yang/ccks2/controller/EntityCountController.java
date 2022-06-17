package com.yang.ccks2.controller;

import com.yang.ccks2.model.CountResultMap;
import com.yang.ccks2.model.EntityCount;
import com.yang.ccks2.service.CcksEntityService;
import com.yang.ccks2.service.EntityCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entity")
public class EntityCountController {

    @Autowired
    private EntityCountService entityCountService;

    @Autowired
    private CcksEntityService ccksEntityService;

    @GetMapping("/count/{textname}")
    public List<EntityCount> countEntityByTextName(@PathVariable("textname") String textName){
        List<EntityCount> entityCountList = entityCountService.countAllEntityByTextName(textName);
        return entityCountList;
    }
    @GetMapping("/countall")
    public List<EntityCount> countAllEntity(){
        List<EntityCount> entityCountList = entityCountService.countAllEntity();
        return entityCountList;
    }
    @GetMapping("/countall2")
    public List<CountResultMap> countAllEntityByEntityName(){
        List<CountResultMap> countResultMapList = ccksEntityService.countAllEntityByEntityName();
        System.out.println(countResultMapList);
        return countResultMapList;
    }

    @GetMapping("/countall3")
    public List<CountResultMap> countAllEntityByEntityName3(){
        List<CountResultMap> countResultMapList = new ArrayList<>();
        CountResultMap countResultMap1 = new CountResultMap();
        countResultMap1.setName("疾病和诊断");
        countResultMap1.setValue(13017);
        countResultMapList.add(countResultMap1);

        CountResultMap countResultMap2 = new CountResultMap();
        countResultMap2.setName("解剖部位");
        countResultMap2.setValue(26433);
        countResultMapList.add(countResultMap2);

        CountResultMap countResultMap3 = new CountResultMap();
        countResultMap3.setName("影像检查");
        countResultMap3.setValue(3006);
        countResultMapList.add(countResultMap3);

        CountResultMap countResultMap4 = new CountResultMap();
        countResultMap4.setName("药物");
        countResultMap4.setValue(5805);
        countResultMapList.add(countResultMap4);

        CountResultMap countResultMap5 = new CountResultMap();
        countResultMap5.setName("手术");
        countResultMap5.setValue(2769);
        countResultMapList.add(countResultMap5);

        CountResultMap countResultMap6 = new CountResultMap();
        countResultMap6.setName("实验室检验");
        countResultMap6.setValue(3768);
        countResultMapList.add(countResultMap6);




        System.out.println(countResultMapList);
        return countResultMapList;
    }
}
