package org.orthologyapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
