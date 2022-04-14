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

  private Long supportCount_Threshold;

  private Long orthologsAboveThreshold;

  private String categoryForThreshold;

  @ManyToOne(targetEntity = MouseGene.class, cascade= CascadeType.ALL)
  @JoinColumn(name = "mouse_gene_id")
  private MouseGene mouseGenes;
}
