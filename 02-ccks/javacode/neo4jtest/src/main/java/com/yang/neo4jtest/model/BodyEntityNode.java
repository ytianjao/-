package com.yang.neo4jtest.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
@NoArgsConstructor
public class BodyEntityNode {
    @Id
    @GeneratedValue
    private Long id;
    private String entityContent;

    public BodyEntityNode(String entityContent) {
        this.entityContent = entityContent;
    }
}
