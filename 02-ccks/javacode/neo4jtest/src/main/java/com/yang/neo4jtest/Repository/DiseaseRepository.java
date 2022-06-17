package com.yang.neo4jtest.Repository;

import com.yang.neo4jtest.model.DiseaseNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiseaseRepository extends Neo4jRepository<DiseaseNode, Long> {
    List<DiseaseNode> findAllByDiseaseName(String name);

    @Query("match(d:disease) return count(d)")
    Integer countAll();
    DiseaseNode findByDiseaseName(String diseaseName);

    @Query("match p=(d:DiseaseNode)<-[rel:`药物`]- (n)where d.diseaseName= $diseaseName return p")
    DiseaseNode findDrugSets(@Param("diseaseName") String diseaseName);

    @Query("match p=(d:DiseaseNode)<-[rel:`解剖部位`]- (n)where d.diseaseName= $diseaseName return p")
    DiseaseNode findBodySets(@Param("diseaseName") String diseaseName);

    @Query("match p=(d:DiseaseNode)<-[rel:`影像检查`]- (n)where d.diseaseName= $diseaseName return p")
    DiseaseNode findCheckSets(@Param("diseaseName") String diseaseName);

    @Query("match p=(d:DiseaseNode)<-[rel:`手术`]- (n)where d.diseaseName= $diseaseName return p")
    DiseaseNode findOperationSets(@Param("diseaseName") String diseaseName);

    @Query("match p=(d:DiseaseNode)<-[rel:`实验室检验`]- (n)where d.diseaseName= $diseaseName return p")
    DiseaseNode findTestSets(@Param("diseaseName") String diseaseName);

    @Query("match p=(d:DiseaseNode)<-[rel:`疾病和诊断`]- (n)where d.diseaseName= $diseaseName return p")
    DiseaseNode findDiseaseSets(@Param("diseaseName") String diseaseName);

    @Query("match p=(d:DiseaseNode) <-[rel:`药物`]- (n:DrugEntityNode) where n.entityContent= $drugContent return d")
    List<DiseaseNode> findDiseaseListByDrugNode(@Param("drugContent") String drugContent);

    @Query("match p=(d:DiseaseNode) <-[rel:`解剖部位`]- (n:BodyEntityNode) where n.entityContent= $bodyContent return d")
    List<DiseaseNode> findDiseaseListByBodyNode(@Param("bodyContent") String bodyContent);

    @Query("match p=(d:DiseaseNode) <-[rel:`影像检查`]- (n:CheckEntityNode) where n.entityContent= $checkContent return d")
    List<DiseaseNode> findDiseaseListByCheckNode(@Param("checkContent") String checkContent);

    @Query("match p=(d:DiseaseNode) <-[rel:`手术`]- (n:OperationEntityNode) where n.entityContent= $operationContent return d")
    List<DiseaseNode> findDiseaseListByOperationNode(@Param("operationContent") String operationContent);

    @Query("match p=(d:DiseaseNode) <-[rel:`实验室检验`]- (n:TestEntityNode) where n.entityContent= $testContent return d")
    List<DiseaseNode> findDiseaseListByTestNode(@Param("testContent") String testContent);

    @Query("match p=(d:DiseaseNode) <-[rel:`疾病和诊断`]- (n:DiseaseNode) where n.diseaseName= $diseaseName return d")
    List<DiseaseNode> findDiseaseListByDiseaseNode(@Param("diseaseName") String diseaseName);

    @Query("match p=(d:DiseaseNode) <-[rel]- (n) where n.entityContent= $entityContent return d")
    List<DiseaseNode> findDiseaseListByEntityNode(@Param("entityContent") String entityContent);

}
