package org.orthologyapi.dto;

public record MouseGeneInfoDto(
    String ensemblChromosome,
    String ensemblGeneAccId,
    Long ensemblStart,
    Long ensemblStop,
    String ensemblStrand,
    String mgiGeneAccId,
    String symbol
) {}
