package org.orthologyapi.dto;

public record EnsemblUrlDto(
    String mgiGeneAccessionId,
    String ensemblGeneAccId
) {}
