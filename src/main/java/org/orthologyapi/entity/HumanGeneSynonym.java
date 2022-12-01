package org.orthologyapi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;

import lombok.Data;

@Entity
@Data
public class HumanGeneSynonym {

  @Id
  private Long id;

  private String hgncAccId;

  private String synonym;

  @ManyToMany(mappedBy = "humanGeneSynonyms")
  private List<HumanGene> humanGenes;
}
