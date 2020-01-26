package com.example;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.Convert;
import org.neo4j.ogm.id.UuidStrategy;
import org.neo4j.ogm.typeconversion.UuidStringConverter;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NodeEntity
public class Person {

    @Id
    @Convert(UuidStringConverter.class)
    @GeneratedValue(strategy = UuidStrategy.class)
    private UUID id;
    private String name;
    private Set<Person> children;
}
