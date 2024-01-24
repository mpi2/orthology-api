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

    private String ensemblGeneAccId;

  @ManyToMany()
  @JoinTable(
      name = "mouseGeneSynonymRelation",
      joinColumns = @JoinColumn(name = "mouseGeneId"),
      inverseJoinColumns = @JoinColumn(name = "mouseGeneSynonymId"))
  private List<MouseGeneSynonym> mouseGeneSynonyms;
}
