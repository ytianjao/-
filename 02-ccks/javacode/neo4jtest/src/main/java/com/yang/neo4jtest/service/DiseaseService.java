package com.yang.neo4jtest.service;

import com.yang.neo4jtest.model.DiseaseNode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiseaseService {
    List<DiseaseNode> getAllDiseaseNodeByEntityNode(String name);
    List<DiseaseNode> getAllDiseaseNodeByBodyNode(String name);
    List<DiseaseNode> getAllDiseaseNodeByCheckNode(String name);
    List<DiseaseNode> getAllDiseaseNodeByTestNode(String name);
    List<DiseaseNode> getAllDiseaseNodeByOperationNode(String name);
    List<DiseaseNode> getAllDiseaseNodeByDrugNode(String name);
    List<DiseaseNode> getAllDiseaseNodeByDiseaseNode(String name);
    DiseaseNode getAllNodeByDiseaeNode(String name);
    DiseaseNode getBodyNodeByDiseaseNode(String name);
    DiseaseNode getCheckNodeByDiseaseNode(String name);
    DiseaseNode getDrugNodeByDiseaseNode(String name);
    DiseaseNode getOperationNodeByDiseaseNode(String name);
    DiseaseNode getTestNodeByDiseaseNode(String name);
    DiseaseNode getDiseaseNodeByDiseaseNode(String name);
}
