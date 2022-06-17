package com.yang.neo4jtest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
@NoArgsConstructor
public class CheckEntityNode {
    @Id
    @GeneratedValue
    private Long id;
    private String entityContent;

    public CheckEntityNode(String entityContent) {
        this.entityContent = entityContent;
    }
}
