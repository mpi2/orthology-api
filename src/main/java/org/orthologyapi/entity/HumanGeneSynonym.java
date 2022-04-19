package org.orthologyapi.entity;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
