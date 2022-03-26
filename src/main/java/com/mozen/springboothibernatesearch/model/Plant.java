package com.mozen.springboothibernatesearch.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.time.Instant;

@Indexed
@Entity
@Table(name = "plant")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Plant {

    public Plant() {
        this.createdAt = Instant.now();
    }

    public Plant(String name, String scientificName, String family) {
        this.name = name;
        this.scientificName = scientificName;
        this.family = family;
        this.createdAt = Instant.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @FullTextField()
    @NaturalId()
    @Column(name = "name")
    private String name;

    @FullTextField()
    @NaturalId()
    @Column(name = "scientificName")
    private String scientificName;

    @FullTextField()
    @Column(name = "family")
    private String family;

    @Column(name = "createdAt")
    private Instant createdAt ;
}
