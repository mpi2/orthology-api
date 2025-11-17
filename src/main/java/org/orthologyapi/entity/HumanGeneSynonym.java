package org.orthologyapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class HumanGeneSynonym {

  @Id
  private Long id;

  private String hgncAccId;

  private String synonym;

  @ManyToMany(mappedBy = "humanGeneSynonyms")
  private List<HumanGene> humanGenes;

  // Constructors
  public HumanGeneSynonym() {}

  public HumanGeneSynonym(Long id, String hgncAccId, String synonym, List<HumanGene> humanGenes) {
    this.id = id;
    this.hgncAccId = hgncAccId;
    this.synonym = synonym;
    this.humanGenes = humanGenes;
  }

  // Getters and Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getHgncAccId() { return hgncAccId; }
  public void setHgncAccId(String hgncAccId) { this.hgncAccId = hgncAccId; }

  public String getSynonym() { return synonym; }
  public void setSynonym(String synonym) { this.synonym = synonym; }

  public List<HumanGene> getHumanGenes() { return humanGenes; }
  public void setHumanGenes(List<HumanGene> humanGenes) { this.humanGenes = humanGenes; }
}
