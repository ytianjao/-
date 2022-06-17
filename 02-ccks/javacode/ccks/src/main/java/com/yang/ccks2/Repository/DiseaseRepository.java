package com.yang.ccks2.Repository;

import com.yang.ccks2.model.disease;
import com.yang.ccks2.model.entity;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiseaseRepository extends Neo4jRepository<disease, Long> {

    @Query("match p=(d:disease)<-[rel:`药物`]- (n)where d.diseaseName='test1' return p")
    List<entity> findDrugSets();

    @Query("match p=(d:disease)<-[]-(n) where d.diseaseName='test1' return n")
    List<disease> find();
    disease findByDiseaseName(String diseaseName);
}
