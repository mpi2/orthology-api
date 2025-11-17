package org.orthologyapi.dto;

public record HumanMappingFilterRecord(
    Long id,
    Long supportCountThreshold,
    Long orthologsAboveThreshold,
    String categoryForThreshold,
    Long humanGeneId
) {}
