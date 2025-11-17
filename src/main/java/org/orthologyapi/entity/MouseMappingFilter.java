package org.orthologyapi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MouseMappingFilter {
  @Id
  private Long id;

  private Long supportCountThreshold;

  private Long orthologsAboveThreshold;

  private String categoryForThreshold;

  @ManyToOne(targetEntity = MouseGene.class, cascade= CascadeType.ALL)
  @JoinColumn(name = "mouseGeneId")
  private MouseGene mouseGenes;

  // Constructors
  public MouseMappingFilter() {}

  public MouseMappingFilter(Long id, Long supportCountThreshold, Long orthologsAboveThreshold, 
                           String categoryForThreshold, MouseGene mouseGenes) {
    this.id = id;
    this.supportCountThreshold = supportCountThreshold;
    this.orthologsAboveThreshold = orthologsAboveThreshold;
    this.categoryForThreshold = categoryForThreshold;
    this.mouseGenes = mouseGenes;
  }

  // Getters and Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public Long getSupportCountThreshold() { return supportCountThreshold; }
  public void setSupportCountThreshold(Long supportCountThreshold) { this.supportCountThreshold = supportCountThreshold; }

  public Long getOrthologsAboveThreshold() { return orthologsAboveThreshold; }
  public void setOrthologsAboveThreshold(Long orthologsAboveThreshold) { this.orthologsAboveThreshold = orthologsAboveThreshold; }

  public String getCategoryForThreshold() { return categoryForThreshold; }
  public void setCategoryForThreshold(String categoryForThreshold) { this.categoryForThreshold = categoryForThreshold; }

  public MouseGene getMouseGenes() { return mouseGenes; }
  public void setMouseGenes(MouseGene mouseGenes) { this.mouseGenes = mouseGenes; }
}
