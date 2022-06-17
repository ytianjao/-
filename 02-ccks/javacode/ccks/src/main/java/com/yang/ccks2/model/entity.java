package com.yang.ccks2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
@NoArgsConstructor
public class entity {

    @Id
    @GeneratedValue
    private Long id;

    private String entityContent;

    public entity(String entityContent) {
        this.entityContent = entityContent;
    }
}
