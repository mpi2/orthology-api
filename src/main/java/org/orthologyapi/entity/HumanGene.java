package org.orthologyapi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;

import lombok.Data;


@Entity
@Data
public class HumanGene {

    @Id
    private Long id;

    private String hgncAccId;

    private String name;

    private String symbol;

    private String ensemblGeneAccId;

    private Long entrezGeneAccId;

    @ManyToMany()
    @JoinTable(
        name = "humanGeneSynonymRelation",
        joinColumns = @JoinColumn(name = "humanGeneId"),
        inverseJoinColumns = @JoinColumn(name = "humanGeneSynonymId"))
    private List<HumanGeneSynonym> humanGeneSynonyms;

}
