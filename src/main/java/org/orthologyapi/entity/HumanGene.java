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

    private String hgnc_acc_id;

    private String name;

    private String symbol;

    private String ensembl_gene_acc_id;

    private Long entrez_gene_acc_id;

    @ManyToMany()
    @JoinTable(
        name = "human_gene_synonym_relation",
        joinColumns = @JoinColumn(name = "human_gene_id"),
        inverseJoinColumns = @JoinColumn(name = "human_gene_synonym_id"))
    private List<HumanGeneSynonym> humanGeneSynonyms;

}
