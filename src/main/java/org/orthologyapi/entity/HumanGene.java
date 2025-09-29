package org.orthologyapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class HumanGene {

    @Id
    private Long id;

    private String hgncAccId;

    private String name;

    private String symbol;

    private String ensemblGeneAccId;

    private Long entrezGeneAccId;

    @ManyToMany()
    @JoinTable(
        name = "humanGeneSynonymRelation",
        joinColumns = @JoinColumn(name = "humanGeneId"),
        inverseJoinColumns = @JoinColumn(name = "humanGeneSynonymId"))
    private List<HumanGeneSynonym> humanGeneSynonyms;

    // Constructors
    public HumanGene() {}

    public HumanGene(Long id, String hgncAccId, String name, String symbol, String ensemblGeneAccId, 
                     Long entrezGeneAccId, List<HumanGeneSynonym> humanGeneSynonyms) {
        this.id = id;
        this.hgncAccId = hgncAccId;
        this.name = name;
        this.symbol = symbol;
        this.ensemblGeneAccId = ensemblGeneAccId;
        this.entrezGeneAccId = entrezGeneAccId;
        this.humanGeneSynonyms = humanGeneSynonyms;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHgncAccId() { return hgncAccId; }
    public void setHgncAccId(String hgncAccId) { this.hgncAccId = hgncAccId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getEnsemblGeneAccId() { return ensemblGeneAccId; }
    public void setEnsemblGeneAccId(String ensemblGeneAccId) { this.ensemblGeneAccId = ensemblGeneAccId; }

    public Long getEntrezGeneAccId() { return entrezGeneAccId; }
    public void setEntrezGeneAccId(Long entrezGeneAccId) { this.entrezGeneAccId = entrezGeneAccId; }

    public List<HumanGeneSynonym> getHumanGeneSynonyms() { return humanGeneSynonyms; }
    public void setHumanGeneSynonyms(List<HumanGeneSynonym> humanGeneSynonyms) { this.humanGeneSynonyms = humanGeneSynonyms; }
}
