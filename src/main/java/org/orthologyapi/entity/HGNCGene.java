package org.orthologyapi.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import javax.persistence.Id;


@Entity
@Data
public class HGNCGene {

    @Id
    private Long id;

    private String agrAccId;

    private String maneSelect;

    private String gencc;

    private String aliasName;

    private String aliasSymbol;

    private String bioparadigmsSlc;

    private String ccdsAccId;

    private String cd;

    private String cosmic;

    private LocalDate dateApprovedReserved;

    private LocalDate dateModified;

    private LocalDate dateNameChanged;

    private LocalDate dateSymbolChanged;

    private String ena;

    private String ensemblGeneAccId;

    private Long entrezAccId;

    private String enzymeAccId;

    private String geneGroup;

    private String geneGroupAccId;

    private String gtrnadb;

    private String hgncAccId;

    private Long homeodb;

    private String hordeAccId;

    private String imgt;

    private String intermediateFilamentDb;

    private String iuphar;

    private Long kznfGeneCatalog;

    private String lncipedia;

    private String lncrnadb;

    private String location;

    private String locationSortable;

    private String locusGroup;

    private String locusType;

    private String lsdb;

    private Long mamitTrnadb;

    private String merops;

    private String mgiGeneAccId;

    private String mirbase;

    private String name;

    private String omimAccId;

    private Long orphanet;

    private String prevName;

    private String prevSymbol;

    private String pseudogeneOrg;

    private String pubmedAccId;

    private String refseqAccession;

    private String rgdAccId;

    private String rnaCentralAccIds;

    private String snornabase;

    private String status;

    private String symbol;

    private String ucscAccId;

    private String uniprotAccIds;

    private String vegaAccId;

    @ManyToOne(targetEntity = HumanGene.class, cascade= CascadeType.ALL)
    @JoinColumn(name = "human_gene_id")
    private HumanGene humanGenes;
}
