package org.orthologyapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class MouseGene {

    @Id
    private Long id;

    private String ensemblChromosome;

    private Long ensemblStart;

    private Long ensemblStop;

    private String ensemblStrand;

    private Long entrezGeneAccId;

    private String genomeBuild;

    private String mgiGeneAccId;

    private String name;

    private String mgiCm;

    private String mgiChromosome;

    private Long mgiStart;

    private Long mgiStop;

    private String mgiStrand;

    private String ncbiChromosome;

    private Long ncbiStart;

    private Long ncbiStop;

    private String ncbiStrand;

    private String symbol;

    private String type;

    private String subtype;

    private String ensemblGeneAccId;

  @ManyToMany()
  @JoinTable(
      name = "mouseGeneSynonymRelation",
      joinColumns = @JoinColumn(name = "mouseGeneId"),
      inverseJoinColumns = @JoinColumn(name = "mouseGeneSynonymId"))
  private List<MouseGeneSynonym> mouseGeneSynonyms;

  // Constructors
  public MouseGene() {}

  public MouseGene(Long id, String ensemblChromosome, Long ensemblStart, Long ensemblStop, String ensemblStrand,
                   Long entrezGeneAccId, String genomeBuild, String mgiGeneAccId, String name, String mgiCm,
                   String mgiChromosome, Long mgiStart, Long mgiStop, String mgiStrand, String ncbiChromosome,
                   Long ncbiStart, Long ncbiStop, String ncbiStrand, String symbol, String type, String subtype,
                   String ensemblGeneAccId, List<MouseGeneSynonym> mouseGeneSynonyms) {
    this.id = id;
    this.ensemblChromosome = ensemblChromosome;
    this.ensemblStart = ensemblStart;
    this.ensemblStop = ensemblStop;
    this.ensemblStrand = ensemblStrand;
    this.entrezGeneAccId = entrezGeneAccId;
    this.genomeBuild = genomeBuild;
    this.mgiGeneAccId = mgiGeneAccId;
    this.name = name;
    this.mgiCm = mgiCm;
    this.mgiChromosome = mgiChromosome;
    this.mgiStart = mgiStart;
    this.mgiStop = mgiStop;
    this.mgiStrand = mgiStrand;
    this.ncbiChromosome = ncbiChromosome;
    this.ncbiStart = ncbiStart;
    this.ncbiStop = ncbiStop;
    this.ncbiStrand = ncbiStrand;
    this.symbol = symbol;
    this.type = type;
    this.subtype = subtype;
    this.ensemblGeneAccId = ensemblGeneAccId;
    this.mouseGeneSynonyms = mouseGeneSynonyms;
  }

  // Getters and Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getEnsemblChromosome() { return ensemblChromosome; }
  public void setEnsemblChromosome(String ensemblChromosome) { this.ensemblChromosome = ensemblChromosome; }

  public Long getEnsemblStart() { return ensemblStart; }
  public void setEnsemblStart(Long ensemblStart) { this.ensemblStart = ensemblStart; }

  public Long getEnsemblStop() { return ensemblStop; }
  public void setEnsemblStop(Long ensemblStop) { this.ensemblStop = ensemblStop; }

  public String getEnsemblStrand() { return ensemblStrand; }
  public void setEnsemblStrand(String ensemblStrand) { this.ensemblStrand = ensemblStrand; }

  public Long getEntrezGeneAccId() { return entrezGeneAccId; }
  public void setEntrezGeneAccId(Long entrezGeneAccId) { this.entrezGeneAccId = entrezGeneAccId; }

  public String getGenomeBuild() { return genomeBuild; }
  public void setGenomeBuild(String genomeBuild) { this.genomeBuild = genomeBuild; }

  public String getMgiGeneAccId() { return mgiGeneAccId; }
  public void setMgiGeneAccId(String mgiGeneAccId) { this.mgiGeneAccId = mgiGeneAccId; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getMgiCm() { return mgiCm; }
  public void setMgiCm(String mgiCm) { this.mgiCm = mgiCm; }

  public String getMgiChromosome() { return mgiChromosome; }
  public void setMgiChromosome(String mgiChromosome) { this.mgiChromosome = mgiChromosome; }

  public Long getMgiStart() { return mgiStart; }
  public void setMgiStart(Long mgiStart) { this.mgiStart = mgiStart; }

  public Long getMgiStop() { return mgiStop; }
  public void setMgiStop(Long mgiStop) { this.mgiStop = mgiStop; }

  public String getMgiStrand() { return mgiStrand; }
  public void setMgiStrand(String mgiStrand) { this.mgiStrand = mgiStrand; }

  public String getNcbiChromosome() { return ncbiChromosome; }
  public void setNcbiChromosome(String ncbiChromosome) { this.ncbiChromosome = ncbiChromosome; }

  public Long getNcbiStart() { return ncbiStart; }
  public void setNcbiStart(Long ncbiStart) { this.ncbiStart = ncbiStart; }

  public Long getNcbiStop() { return ncbiStop; }
  public void setNcbiStop(Long ncbiStop) { this.ncbiStop = ncbiStop; }

  public String getNcbiStrand() { return ncbiStrand; }
  public void setNcbiStrand(String ncbiStrand) { this.ncbiStrand = ncbiStrand; }

  public String getSymbol() { return symbol; }
  public void setSymbol(String symbol) { this.symbol = symbol; }

  public String getType() { return type; }
  public void setType(String type) { this.type = type; }

  public String getSubtype() { return subtype; }
  public void setSubtype(String subtype) { this.subtype = subtype; }

  public String getEnsemblGeneAccId() { return ensemblGeneAccId; }
  public void setEnsemblGeneAccId(String ensemblGeneAccId) { this.ensemblGeneAccId = ensemblGeneAccId; }

  public List<MouseGeneSynonym> getMouseGeneSynonyms() { return mouseGeneSynonyms; }
  public void setMouseGeneSynonyms(List<MouseGeneSynonym> mouseGeneSynonyms) { this.mouseGeneSynonyms = mouseGeneSynonyms; }
}
