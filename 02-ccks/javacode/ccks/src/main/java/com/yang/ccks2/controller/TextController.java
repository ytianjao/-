package com.yang.ccks2.controller;

import com.github.pagehelper.PageInfo;
import com.yang.ccks2.model.CcksText;
import com.yang.ccks2.service.CcksTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cckstext")
public class TextController {

    @Autowired
    private CcksTextService ccksTextService;

    @PostMapping("/add")
    public String addCcksText(@RequestBody CcksText ccksText) {
        int i = ccksTextService.insertCcksText(ccksText);
        if (i != 0) {
            return "success";
        } else {
            return "false";
        }
    }

    @DeleteMapping("/delete")
    public String deleteCcksText(@RequestParam("textId") Long textId) {
        int i = ccksTextService.deleteCcksText(textId);
        if (i != 0) {
            return "success";
        } else {
            return "false";
        }
    }

    @PostMapping("/update/{id}")
    public String updateCcksText(@PathVariable("id") Long id, @RequestBody CcksText ccksText) {
        int i = ccksTextService.updateCcksText(id, ccksText);

        if (i != 0) {
            return "success";
        } else {
            return "false";
        }
    }

    @GetMapping("/select/{id}")
    public CcksText selectCcksText(@PathVariable("id") Long id) {
        return ccksTextService.selectCcksTextById(id);
    }

    @GetMapping("/listall")
    public List<CcksText> findAllCcksText() {
        return ccksTextService.findCcksTextList();
    }

    @GetMapping("/listallbypage")
    public PageInfo findAllCcksTextByPage(@RequestParam(value = "pagenum", defaultValue = "1") int pageNum, @RequestParam(value = "pagesize", defaultValue = "3") int pageSize) {
        if (pageNum <1){
            pageNum = 1;
        }
        return ccksTextService.findCcksTextListByPage(pageNum, pageSize);
    }


    @GetMapping("/listallbycontentbypage")
    public PageInfo findAllCcksTextByContentByPage(@RequestParam(value = "pagenum", defaultValue = "1") int pageNum, @RequestParam(value = "pagesize", defaultValue = "5") int pageSize) {
        if (pageNum <1){
            pageNum = 1;
        }
        return ccksTextService.findCcksTextListByContentBypage(pageNum, pageSize);
    }

}
