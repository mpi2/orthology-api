package org.orthologyapi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;

import lombok.Data;


@Entity
@Data
public class MouseGeneSynonym {

  @Id
  private Long id;

  private Long mgiGeneAccId;

  private String synonym;

  @ManyToMany(mappedBy = "mouseGeneSynonyms")
  private List<MouseGene> mouseGenes;


}
