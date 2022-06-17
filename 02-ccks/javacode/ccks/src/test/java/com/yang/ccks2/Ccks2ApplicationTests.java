package com.yang.ccks2;

import com.yang.ccks2.Repository.DiseaseRepository;
import com.yang.ccks2.model.CcksUser;
import com.yang.ccks2.model.disease;
import com.yang.ccks2.model.entity;
import com.yang.ccks2.service.CcksUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Ccks2ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private CcksUserService ccksUserService;

    @Test
    void insertTest() {
        CcksUser ccksUser = new CcksUser();
        ccksUser.setUserName("test");
        int user = ccksUserService.insertCcksUser(ccksUser);
        System.out.println(user);
    }

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Test
    void getDrugSet() {
//        disease test1 = diseaseRepository.findByDiseaseName("test1");
        List<entity> test1 = diseaseRepository.findDrugSets();
        System.out.println(test1);

    }

    @Test
    void addNode() {
        disease test1 = new disease("test1");
        disease test2 = new disease("test2");
        disease test3 = new disease("test3");

        entity entity1 = new entity("entity1");
        entity entity2 = new entity("entity2");
        test1.diseaseWorkWith(test2);
        test1.diseaseWorkWith(test3);
        test1.drugWorkWith(entity1);
        test1.drugWorkWith(entity2);
        diseaseRepository.save(test1);
    }

    @Test
    void find() {
        disease test1 = diseaseRepository.findByDiseaseName("test1");
        System.out.println(test1);
    }

}
