package com.yang.ccks2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node
@Data
@NoArgsConstructor
public class disease {

    @Id
    @GeneratedValue
    private Long id;
    private String diseaseName;

    @Relationship(type = "疾病和诊断", direction = Relationship.Direction.INCOMING)
    private Set<disease> diseaseSet = new HashSet<>();

    @Relationship(type = "药物", direction = Relationship.Direction.INCOMING)
    private Set<entity> drugSet = new HashSet<>();

    public void diseaseWorkWith(disease dis) {
        if (diseaseSet == null) {
            diseaseSet = new HashSet<>();
        }
        diseaseSet.add(dis);
    }

    public void drugWorkWith(entity ent) {
        if (drugSet == null) {
            drugSet = new HashSet<>();
        }
        drugSet.add(ent);
    }

    public disease(String diseaseName) {
        this.diseaseName = diseaseName;
    }

}
