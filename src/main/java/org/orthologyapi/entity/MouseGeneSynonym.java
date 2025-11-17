package org.orthologyapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class MouseGeneSynonym {

  @Id
  private Long id;

  private Long mgiGeneAccId;

  private String synonym;

  @ManyToMany(mappedBy = "mouseGeneSynonyms")
  private List<MouseGene> mouseGenes;

  // Constructors
  public MouseGeneSynonym() {}

  public MouseGeneSynonym(Long id, Long mgiGeneAccId, String synonym, List<MouseGene> mouseGenes) {
    this.id = id;
    this.mgiGeneAccId = mgiGeneAccId;
    this.synonym = synonym;
    this.mouseGenes = mouseGenes;
  }

  // Getters and Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public Long getMgiGeneAccId() { return mgiGeneAccId; }
  public void setMgiGeneAccId(Long mgiGeneAccId) { this.mgiGeneAccId = mgiGeneAccId; }

  public String getSynonym() { return synonym; }
  public void setSynonym(String synonym) { this.synonym = synonym; }

  public List<MouseGene> getMouseGenes() { return mouseGenes; }
  public void setMouseGenes(List<MouseGene> mouseGenes) { this.mouseGenes = mouseGenes; }
}
