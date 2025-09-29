package org.orthologyapi.dto;

public record MouseGeneRecord(
    Long id,
    String ensemblChromosome,
    Long ensemblStart,
    Long ensemblStop,
    String ensemblStrand,
    Long entrezGeneAccId,
    String genomeBuild,
    String mgiGeneAccId,
    String name,
    String mgiCm,
    String mgiChromosome,
    Long mgiStart,
    Long mgiStop,
    String mgiStrand,
    String ncbiChromosome,
    Long ncbiStart,
    Long ncbiStop,
    String ncbiStrand,
    String symbol,
    String type,
    String subtype,
    String ensemblGeneAccId
) {}
