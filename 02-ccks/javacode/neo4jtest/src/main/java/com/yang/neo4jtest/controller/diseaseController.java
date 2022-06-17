package com.yang.neo4jtest.controller;

import com.yang.neo4jtest.model.*;
import com.yang.neo4jtest.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
@CrossOrigin
public class diseaseController {


    @Autowired
    private DiseaseService diseaseService;

//    @GetMapping("/diseasesbybody/{name}")
//    public List<DiseaseNode> getDiseaseListByBody(@PathVariable("name") String name){
//        List<DiseaseNode> allDiseaseNodeByBodyNode = diseaseService.getAllDiseaseNodeByBodyNode(name);
//        return allDiseaseNodeByBodyNode;
//    }

    @GetMapping("/diseasesbyentitynode/{name}")
    public List<DiseaseNode> getDiseaseListByEntityNode(@PathVariable("name") String name){
        List<DiseaseNode> allDiseaseNodeByNode = diseaseService.getAllDiseaseNodeByEntityNode(name);
        return allDiseaseNodeByNode;
    }

    @GetMapping("/nodesbydisease/{name}")
    public DiseaseNode getAllNodeByDiseaseNode(@PathVariable("name") String name){
        DiseaseNode allNodeByDiseaeNode = diseaseService.getAllNodeByDiseaeNode(name);
        return allNodeByDiseaeNode;
    }

    @GetMapping("/bodynodesbydisease/{name}")
    public Set getBodyNodeByDiseaseNode(@PathVariable("name") String name){
        DiseaseNode bodyNodesByDiseaseNode = diseaseService.getBodyNodeByDiseaseNode(name);
        Set<BodyEntityNode> bodyEntityNodeSet = bodyNodesByDiseaseNode.getBodyEntityNodeSet();
        return bodyEntityNodeSet;
    }

    @GetMapping("/checknodesbydisease/{name}")
    public Set getCheckNodeByDiseaseNode(@PathVariable("name") String name){
        DiseaseNode checkNodeByDiseaseNode = diseaseService.getCheckNodeByDiseaseNode(name);
        Set<CheckEntityNode> checkEntityNodeSet = checkNodeByDiseaseNode.getCheckEntityNodeSet();
        return checkEntityNodeSet;
    }

    @GetMapping("/drugnodesbydisease/{name}")
    public Set getDrugNodeByDiseaseNode(@PathVariable("name") String name){
        DiseaseNode drugNodeByDiseaseNode = diseaseService.getDrugNodeByDiseaseNode(name);
        Set<DrugEntityNode> drugEntityNodeSet = drugNodeByDiseaseNode.getDrugEntityNodeSet();
        return drugEntityNodeSet;
    }

    @GetMapping("/operationnodesbydisease/{name}")
    public Set getOperationNodeByDiseaseNode(@PathVariable("name") String name){
        DiseaseNode operationNodeByDiseaseNode = diseaseService.getOperationNodeByDiseaseNode(name);
        Set<OperationEntityNode> operationEntityNodeSet = operationNodeByDiseaseNode.getOperationEntityNodeSet();
        return operationEntityNodeSet;
    }

    @GetMapping("/testnodesbydisease/{name}")
    public Set getTestNodeByDiseaseNode(@PathVariable("name") String name){
        DiseaseNode testNodeByDiseaseNode = diseaseService.getTestNodeByDiseaseNode(name);
        Set<TestEntityNode> testEntityNodeSet = testNodeByDiseaseNode.getTestEntityNodeSet();
        return testEntityNodeSet;
    }

    @GetMapping("/diseasenodesbydisease/{name}")
    public List<DiseaseNode> getDiseaseNodeByDiseaseNode(@PathVariable("name") String name){
        List<DiseaseNode> allDiseaseNodeByDiseaseNode = diseaseService.getAllDiseaseNodeByDiseaseNode(name);
        return allDiseaseNodeByDiseaseNode;
    }

}
