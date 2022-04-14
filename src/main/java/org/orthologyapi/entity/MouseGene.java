package org.orthologyapi.entity;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import javax.persistence.Id;

@Entity
@Data
public class MouseGene {

    @Id
    private Long id;

    private String ensemblChromosome;

    private String ensemblGeneGccId;

    private Long ensemblStart;

    private Long ensemblStop;

    private String ensemblStrand;

    private Long entrezGeneAccId;

    private String genomeBuild;

    private String mgiGeneAccId;

    private String name;

    private String mgiCm;

    private String mgiChromosome;

    private Long mgiStart;

    private Long mgiStop;

    private String mgiStrand;

    private String ncbiChromosome;

    private Long ncbiStart;

    private Long ncbiStop;

    private String ncbiStrand;

    private String symbol;

    private String type;

    private String subtype;

  @ManyToMany()
  @JoinTable(
      name = "mouse_gene_synonym_relation",
      joinColumns = @JoinColumn(name = "mouse_gene_id"),
      inverseJoinColumns = @JoinColumn(name = "mouse_gene_synonym_id"))
  private List<MouseGeneSynonym> mouseGeneSynonyms;
}
