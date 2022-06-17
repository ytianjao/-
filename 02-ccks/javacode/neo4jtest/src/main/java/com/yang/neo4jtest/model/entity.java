package com.yang.neo4jtest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
@NoArgsConstructor
@Data
public class entity {

    @Id
    @GeneratedValue
    private Long id;

    private String entityContent;



    public entity(String entityContent) {
        this.entityContent = entityContent;
    }
}
