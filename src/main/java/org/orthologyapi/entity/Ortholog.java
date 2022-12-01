package org.orthologyapi.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Ortholog {
  @Id
  private Long id;

  private String support;

  private String supportRaw;

  private Long supportCount;

  private String category;

  private String isMaxHumanToMouse;

  private String isMaxMouseToHuman;

  @ManyToOne(targetEntity = MouseGene.class, cascade= CascadeType.ALL)
  @JoinColumn(name = "mouseGeneId")
  private MouseGene mouseGenes;

  @ManyToOne(targetEntity = HumanGene.class, cascade=CascadeType.ALL)
  @JoinColumn(name = "humanGeneId")
  private HumanGene humanGenes;

}
