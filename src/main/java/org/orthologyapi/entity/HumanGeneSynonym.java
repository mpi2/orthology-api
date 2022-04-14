package org.orthologyapi.entity;


import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import javax.persistence.Id;

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
