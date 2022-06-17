package com.yang.neo4jtest.Repository;

import com.yang.neo4jtest.model.entity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ENtityRepository extends Neo4jRepository<entity, Long> {
    List<entity> findAllByEntityContentEquals(@Param("entityContent") String name);
    @Query("match (e:entity)-[r]->(d:disease) where e.entityContent=~ $entityContent return e,d,r")
    Object find(@Param("entityContent") String entityContent);
    @Query("match (e:entity) where e.entityContent=~ $entityContent return e")
    entity findByEntityContent(@Param("entityContent") String entityContent);
}
