package org.orthologyapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity(name = "hgnc_gene")
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
    private String rnaCentralId;
    private String snornabase;
    private String status;
    private String symbol;
    private String ucscAccId;
    private String uniprotAccIds;

    // Constructors
    public HGNCGene() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAgrAccId() { return agrAccId; }
    public void setAgrAccId(String agrAccId) { this.agrAccId = agrAccId; }

    public String getManeSelect() { return maneSelect; }
    public void setManeSelect(String maneSelect) { this.maneSelect = maneSelect; }

    public String getGencc() { return gencc; }
    public void setGencc(String gencc) { this.gencc = gencc; }

    public String getAliasName() { return aliasName; }
    public void setAliasName(String aliasName) { this.aliasName = aliasName; }

    public String getAliasSymbol() { return aliasSymbol; }
    public void setAliasSymbol(String aliasSymbol) { this.aliasSymbol = aliasSymbol; }

    public String getBioparadigmsSlc() { return bioparadigmsSlc; }
    public void setBioparadigmsSlc(String bioparadigmsSlc) { this.bioparadigmsSlc = bioparadigmsSlc; }

    public String getCcdsAccId() { return ccdsAccId; }
    public void setCcdsAccId(String ccdsAccId) { this.ccdsAccId = ccdsAccId; }

    public String getCd() { return cd; }
    public void setCd(String cd) { this.cd = cd; }

    public String getCosmic() { return cosmic; }
    public void setCosmic(String cosmic) { this.cosmic = cosmic; }

    public LocalDate getDateApprovedReserved() { return dateApprovedReserved; }
    public void setDateApprovedReserved(LocalDate dateApprovedReserved) { this.dateApprovedReserved = dateApprovedReserved; }

    public LocalDate getDateModified() { return dateModified; }
    public void setDateModified(LocalDate dateModified) { this.dateModified = dateModified; }

    public LocalDate getDateNameChanged() { return dateNameChanged; }
    public void setDateNameChanged(LocalDate dateNameChanged) { this.dateNameChanged = dateNameChanged; }

    public LocalDate getDateSymbolChanged() { return dateSymbolChanged; }
    public void setDateSymbolChanged(LocalDate dateSymbolChanged) { this.dateSymbolChanged = dateSymbolChanged; }

    public String getEna() { return ena; }
    public void setEna(String ena) { this.ena = ena; }

    public String getEnsemblGeneAccId() { return ensemblGeneAccId; }
    public void setEnsemblGeneAccId(String ensemblGeneAccId) { this.ensemblGeneAccId = ensemblGeneAccId; }

    public Long getEntrezAccId() { return entrezAccId; }
    public void setEntrezAccId(Long entrezAccId) { this.entrezAccId = entrezAccId; }

    public String getEnzymeAccId() { return enzymeAccId; }
    public void setEnzymeAccId(String enzymeAccId) { this.enzymeAccId = enzymeAccId; }

    public String getGeneGroup() { return geneGroup; }
    public void setGeneGroup(String geneGroup) { this.geneGroup = geneGroup; }

    public String getGeneGroupAccId() { return geneGroupAccId; }
    public void setGeneGroupAccId(String geneGroupAccId) { this.geneGroupAccId = geneGroupAccId; }

    public String getGtrnadb() { return gtrnadb; }
    public void setGtrnadb(String gtrnadb) { this.gtrnadb = gtrnadb; }

    public String getHgncAccId() { return hgncAccId; }
    public void setHgncAccId(String hgncAccId) { this.hgncAccId = hgncAccId; }

    public Long getHomeodb() { return homeodb; }
    public void setHomeodb(Long homeodb) { this.homeodb = homeodb; }

    public String getHordeAccId() { return hordeAccId; }
    public void setHordeAccId(String hordeAccId) { this.hordeAccId = hordeAccId; }

    public String getImgt() { return imgt; }
    public void setImgt(String imgt) { this.imgt = imgt; }

    public String getIntermediateFilamentDb() { return intermediateFilamentDb; }
    public void setIntermediateFilamentDb(String intermediateFilamentDb) { this.intermediateFilamentDb = intermediateFilamentDb; }

    public String getIuphar() { return iuphar; }
    public void setIuphar(String iuphar) { this.iuphar = iuphar; }

    public Long getKznfGeneCatalog() { return kznfGeneCatalog; }
    public void setKznfGeneCatalog(Long kznfGeneCatalog) { this.kznfGeneCatalog = kznfGeneCatalog; }

    public String getLncipedia() { return lncipedia; }
    public void setLncipedia(String lncipedia) { this.lncipedia = lncipedia; }

    public String getLncrnadb() { return lncrnadb; }
    public void setLncrnadb(String lncrnadb) { this.lncrnadb = lncrnadb; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getLocationSortable() { return locationSortable; }
    public void setLocationSortable(String locationSortable) { this.locationSortable = locationSortable; }

    public String getLocusGroup() { return locusGroup; }
    public void setLocusGroup(String locusGroup) { this.locusGroup = locusGroup; }

    public String getLocusType() { return locusType; }
    public void setLocusType(String locusType) { this.locusType = locusType; }

    public String getLsdb() { return lsdb; }
    public void setLsdb(String lsdb) { this.lsdb = lsdb; }

    public Long getMamitTrnadb() { return mamitTrnadb; }
    public void setMamitTrnadb(Long mamitTrnadb) { this.mamitTrnadb = mamitTrnadb; }

    public String getMerops() { return merops; }
    public void setMerops(String merops) { this.merops = merops; }

    public String getMgiGeneAccId() { return mgiGeneAccId; }
    public void setMgiGeneAccId(String mgiGeneAccId) { this.mgiGeneAccId = mgiGeneAccId; }

    public String getMirbase() { return mirbase; }
    public void setMirbase(String mirbase) { this.mirbase = mirbase; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOmimAccId() { return omimAccId; }
    public void setOmimAccId(String omimAccId) { this.omimAccId = omimAccId; }

    public Long getOrphanet() { return orphanet; }
    public void setOrphanet(Long orphanet) { this.orphanet = orphanet; }

    public String getPrevName() { return prevName; }
    public void setPrevName(String prevName) { this.prevName = prevName; }

    public String getPrevSymbol() { return prevSymbol; }
    public void setPrevSymbol(String prevSymbol) { this.prevSymbol = prevSymbol; }

    public String getPseudogeneOrg() { return pseudogeneOrg; }
    public void setPseudogeneOrg(String pseudogeneOrg) { this.pseudogeneOrg = pseudogeneOrg; }

    public String getPubmedAccId() { return pubmedAccId; }
    public void setPubmedAccId(String pubmedAccId) { this.pubmedAccId = pubmedAccId; }

    public String getRefseqAccession() { return refseqAccession; }
    public void setRefseqAccession(String refseqAccession) { this.refseqAccession = refseqAccession; }

    public String getRgdAccId() { return rgdAccId; }
    public void setRgdAccId(String rgdAccId) { this.rgdAccId = rgdAccId; }

    public String getRnaCentralId() { return rnaCentralId; }
    public void setRnaCentralId(String rnaCentralId) { this.rnaCentralId = rnaCentralId; }

    public String getSnornabase() { return snornabase; }
    public void setSnornabase(String snornabase) { this.snornabase = snornabase; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getUcscAccId() { return ucscAccId; }
    public void setUcscAccId(String ucscAccId) { this.ucscAccId = ucscAccId; }

    public String getUniprotAccIds() { return uniprotAccIds; }
    public void setUniprotAccIds(String uniprotAccIds) { this.uniprotAccIds = uniprotAccIds; }
}