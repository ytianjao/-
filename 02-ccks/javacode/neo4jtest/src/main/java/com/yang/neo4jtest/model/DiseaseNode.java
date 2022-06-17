package com.yang.neo4jtest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
@Data
@NoArgsConstructor
public class DiseaseNode {

    @Id
    @GeneratedValue
    private Long id;
    private String diseaseName;

    @Relationship(type = "疾病和诊断", direction = Relationship.INCOMING)
    private Set<DiseaseNode> diseaseNodeSet = new HashSet<>();

    @Relationship(type = "实验室检验", direction = Relationship.INCOMING)
    private Set<TestEntityNode> testEntityNodeSet = new HashSet<>();

    @Relationship(type = "解剖部位", direction = Relationship.INCOMING)
    private Set<BodyEntityNode> bodyEntityNodeSet = new HashSet<>();

    @Relationship(type = "影像检查", direction = Relationship.INCOMING)
    private Set<CheckEntityNode> checkEntityNodeSet = new HashSet<>();

    @Relationship(type = "药物", direction = Relationship.INCOMING)
    private Set<DrugEntityNode> drugEntityNodeSet = new HashSet<>();

    @Relationship(type = "手术", direction = Relationship.INCOMING)
    private Set<OperationEntityNode> operationEntityNodeSet = new HashSet<>();



    public void diseaseWorkWith(DiseaseNode dis) {
        if (this.diseaseNodeSet == null) {
            this.diseaseNodeSet = new HashSet<>();
        }
        diseaseNodeSet.add(dis);
    }



    public DiseaseNode(String diseaseName) {
        this.diseaseName = diseaseName;
    }
}
