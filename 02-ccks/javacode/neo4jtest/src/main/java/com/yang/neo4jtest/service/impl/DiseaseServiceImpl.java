package com.yang.neo4jtest.service.impl;

import com.yang.neo4jtest.Repository.DiseaseRepository;
import com.yang.neo4jtest.model.DiseaseNode;
import com.yang.neo4jtest.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;
    @Override
    public List<DiseaseNode> getAllDiseaseNodeByEntityNode(String name) {
        List<DiseaseNode> diseaseListByEntityNode = diseaseRepository.findDiseaseListByEntityNode(name);

        return diseaseListByEntityNode;
    }

    @Override
    public List<DiseaseNode> getAllDiseaseNodeByBodyNode(String name) {
        List<DiseaseNode> diseaseListByBodyNode = diseaseRepository.findDiseaseListByBodyNode(name);
        return diseaseListByBodyNode;
    }

    @Override
    public List<DiseaseNode> getAllDiseaseNodeByCheckNode(String name) {
        List<DiseaseNode> diseaseListByCheckNode = diseaseRepository.findDiseaseListByCheckNode(name);
        return diseaseListByCheckNode;
    }

    @Override
    public List<DiseaseNode> getAllDiseaseNodeByTestNode(String name) {
        List<DiseaseNode> diseaseListByTestNode = diseaseRepository.findDiseaseListByTestNode(name);
        return diseaseListByTestNode;
    }

    @Override
    public List<DiseaseNode> getAllDiseaseNodeByOperationNode(String name) {
        List<DiseaseNode> diseaseListByOperationNode = diseaseRepository.findDiseaseListByOperationNode(name);
        return diseaseListByOperationNode;
    }

    @Override
    public List<DiseaseNode> getAllDiseaseNodeByDrugNode(String name) {
        List<DiseaseNode> diseaseListByDrugNode = diseaseRepository.findDiseaseListByDrugNode(name);
        return diseaseListByDrugNode;
    }

    @Override
    public List<DiseaseNode> getAllDiseaseNodeByDiseaseNode(String name) {
        List<DiseaseNode> diseaseListByDiseaseNode = diseaseRepository.findDiseaseListByDiseaseNode(name);
        return diseaseListByDiseaseNode;
    }

    @Override
    public DiseaseNode getAllNodeByDiseaeNode(String name) {
        DiseaseNode byDiseaseName = diseaseRepository.findByDiseaseName(name);
        return byDiseaseName;
    }

    @Override
    public DiseaseNode getBodyNodeByDiseaseNode(String name) {
        DiseaseNode bodySets = diseaseRepository.findBodySets(name);
        return bodySets;
    }

    @Override
    public DiseaseNode getCheckNodeByDiseaseNode(String name) {
        DiseaseNode checkSets = diseaseRepository.findCheckSets(name);
        return checkSets;
    }

    @Override
    public DiseaseNode getDrugNodeByDiseaseNode(String name) {
        DiseaseNode drugSets = diseaseRepository.findDrugSets(name);
        return drugSets;
    }

    @Override
    public DiseaseNode getOperationNodeByDiseaseNode(String name) {
        DiseaseNode operationSets = diseaseRepository.findOperationSets(name);
        return operationSets;
    }

    @Override
    public DiseaseNode getTestNodeByDiseaseNode(String name) {
        DiseaseNode testSets = diseaseRepository.findTestSets(name);
        return testSets;
    }

    @Override
    public DiseaseNode getDiseaseNodeByDiseaseNode(String name) {
        DiseaseNode diseaseSets = diseaseRepository.findDiseaseSets(name);
        return diseaseSets;
    }
}
