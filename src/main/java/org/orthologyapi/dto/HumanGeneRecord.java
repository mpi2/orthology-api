package org.orthologyapi.dto;

public record HumanGeneRecord(
    Long id,
    String hgncAccId,
    String name,
    String symbol,
    String ensemblGeneAccId,
    Long entrezGeneAccId
) {}
