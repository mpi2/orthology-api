package org.orthologyapi.dto;

public record HumanGeneSynonymRecord(
    Long id,
    String hgncAccId,
    String synonym
) {}
