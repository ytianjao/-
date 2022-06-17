package com.yang.neo4jtest;

import com.yang.neo4jtest.Repository.DiseaseRepository;
import com.yang.neo4jtest.Repository.ENtityRepository;
import com.yang.neo4jtest.model.DiseaseNode;
import com.yang.neo4jtest.model.entity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@EnableNeo4jRepositories
class Neo4jtestApplicationTests {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private ENtityRepository eNtityRepository;



    @Test
    void contextLoads() {
    }

    @Test
    void findAllDisNode(){
        DiseaseNode DiseaseNode = diseaseRepository.findByDiseaseName("胃窦大弯侧腺癌（中度分化），浸润溃疡型");
        System.out.println(DiseaseNode);
//        System.out.println(diseaseNodeList.size());
    }


    @Test
    void getEntity(){
        List<entity> all = eNtityRepository.findAllByEntityContentEquals("泰勒宁");
        System.out.println(all);
    }

    @Test
    void count(){
        DiseaseNode diseaseNodeName = diseaseRepository.findByDiseaseName("肝癌");
        System.out.println(diseaseNodeName);
    }



    @Test
    void find(){
//        DiseaseNode test1 = diseaseRepository.findByDiseaseName("肝癌");
//        List<DiseaseNode> listByDrugNode = diseaseRepository.findDiseaseListByDiseaseNode("肝癌");
//        DiseaseNode diseaseNode = diseaseRepository.findTestSets( "肝癌");
//        System.out.println(diseaseNode);

        List<DiseaseNode> diseaseListByNode = diseaseRepository.findDiseaseListByEntityNode("主动脉窦部");
        System.out.println(diseaseListByNode);
    }

    @Test
    void deleteAll(){
        diseaseRepository.deleteAll();
    }

}
