package org.orthologyapi.dto;

public record MouseMappingFilterRecord(
    Long id,
    Long supportCountThreshold,
    Long orthologsAboveThreshold,
    String categoryForThreshold,
    Long mouseGeneId
) {}
