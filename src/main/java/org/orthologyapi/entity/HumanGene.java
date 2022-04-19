package org.orthologyapi.entity;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
