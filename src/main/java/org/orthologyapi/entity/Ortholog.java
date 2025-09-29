package org.orthologyapi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
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

  // Constructors
  public Ortholog() {}

  public Ortholog(Long id, String support, String supportRaw, Long supportCount, String category, 
                  String isMaxHumanToMouse, String isMaxMouseToHuman, MouseGene mouseGenes, HumanGene humanGenes) {
    this.id = id;
    this.support = support;
    this.supportRaw = supportRaw;
    this.supportCount = supportCount;
    this.category = category;
    this.isMaxHumanToMouse = isMaxHumanToMouse;
    this.isMaxMouseToHuman = isMaxMouseToHuman;
    this.mouseGenes = mouseGenes;
    this.humanGenes = humanGenes;
  }

  // Getters and Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getSupport() { return support; }
  public void setSupport(String support) { this.support = support; }

  public String getSupportRaw() { return supportRaw; }
  public void setSupportRaw(String supportRaw) { this.supportRaw = supportRaw; }

  public Long getSupportCount() { return supportCount; }
  public void setSupportCount(Long supportCount) { this.supportCount = supportCount; }

  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }

  public String getIsMaxHumanToMouse() { return isMaxHumanToMouse; }
  public void setIsMaxHumanToMouse(String isMaxHumanToMouse) { this.isMaxHumanToMouse = isMaxHumanToMouse; }

  public String getIsMaxMouseToHuman() { return isMaxMouseToHuman; }
  public void setIsMaxMouseToHuman(String isMaxMouseToHuman) { this.isMaxMouseToHuman = isMaxMouseToHuman; }

  public MouseGene getMouseGenes() { return mouseGenes; }
  public void setMouseGenes(MouseGene mouseGenes) { this.mouseGenes = mouseGenes; }

  public HumanGene getHumanGenes() { return humanGenes; }
  public void setHumanGenes(HumanGene humanGenes) { this.humanGenes = humanGenes; }
}
