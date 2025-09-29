package org.orthologyapi.dto;

public record MouseGeneSynonymRecord(
    Long id,
    Long mgiGeneAccId,
    String synonym
) {}
