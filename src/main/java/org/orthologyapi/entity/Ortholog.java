package org.orthologyapi.entity;


import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import javax.persistence.Id;
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

  @ManyToOne(targetEntity = MouseGene.class, cascade=CascadeType.ALL)
  @JoinColumn(name = "mouse_gene_id")
  private MouseGene mouseGenes;

  @ManyToOne(targetEntity = HumanGene.class, cascade=CascadeType.ALL)
  @JoinColumn(name = "human_gene_id")
  private HumanGene humanGenes;

}
