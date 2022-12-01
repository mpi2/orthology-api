package org.orthologyapi.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class MouseMappingFilter {
  @Id
  private Long id;

  private Long supportCountThreshold;

  private Long orthologsAboveThreshold;

  private String categoryForThreshold;

  @ManyToOne(targetEntity = MouseGene.class, cascade= CascadeType.ALL)
  @JoinColumn(name = "mouseGeneId")
  private MouseGene mouseGenes;
}
