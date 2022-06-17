package com.yang.ccks2.controller;

import com.yang.ccks2.model.TextCount;
import com.yang.ccks2.service.CcksTextService;
import com.yang.ccks2.service.TextCountService;
import com.yang.ccks2.utils.CountResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/count")
public class TextCountController {

    @Autowired
    private TextCountService textCountService;

    @Autowired
    private CcksTextService ccksTextService;

    @GetMapping("/text")
    public List<TextCount> countTextByName(){
        return textCountService.countTextByName();
    }
    @GetMapping("/text2")
    public List<CountResultMap> countTextByTextName(){
//        List<CountResultMap> countResultMaps = ccksTextService.countAllByTextName();
        List<CountResultMap> countResultMaps = new ArrayList<>();

        CountResultMap result2018 = new CountResultMap();
        result2018.setName("CCKS2018");
        result2018.setValue(20796);
        countResultMaps.add(result2018);

        CountResultMap result2019 = new CountResultMap();
        result2019.setName("CCKS2019");
        result2019.setValue(23655);
        countResultMaps.add(result2019);

        CountResultMap result2020 = new CountResultMap();
        result2020.setName("CCKS2020");
        result2020.setValue(25792);
        countResultMaps.add(result2020);
        System.out.println(countResultMaps);

        return countResultMaps;

    }
}
