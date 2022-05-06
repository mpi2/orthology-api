package org.orthologyapi.entity;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.Data;
import javax.persistence.Id;

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
