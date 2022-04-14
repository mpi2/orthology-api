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

  private Long support_count_threshold;

  private Long orthologs_above_threshold;

  private String category_for_threshold;

  @ManyToOne(targetEntity = HumanGene.class, cascade= CascadeType.ALL)
  @JoinColumn(name = "human_gene_id")
  private HumanGene humanGenes;
}
