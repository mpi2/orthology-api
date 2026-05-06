package org.orthologyapi.dto;

public record MouseGeneFullDto(
    String ensemblChromosome,
    String ensemblGeneAccId,
    Long ensemblStart,
    Long ensemblStop,
    String ensemblStrand,
    Long entrezGeneAccId,
    String genomeBuild,
    String mgiChromosome,
    String mgiCm,
    String mgiGeneAccId,
    Long mgiStart,
    Long mgiStop,
    String mgiStrand,
    String name,
    String ncbiChromosome,
    Long ncbiStart,
    Long ncbiStop,
    String ncbiStrand,
    String subtype,
    String symbol,
    String type
) {}
