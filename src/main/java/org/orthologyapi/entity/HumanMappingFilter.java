package org.orthologyapi.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import javax.persistence.Id;

@Entity
@Data
public class HumanMappingFilter {

  @Id
  private Long id;

  private Long supportCountThreshold;

  private Long orthologsAboveThreshold;

  private String categoryForThreshold;

  @ManyToOne(targetEntity = HumanGene.class, cascade= CascadeType.ALL)
  @JoinColumn(name = "humanGeneId")
  private HumanGene humanGenes;
}
