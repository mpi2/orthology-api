package org.orthologyapi.dto;

public record CoordinatesDto(
    String chromosome,
    Integer start,
    Integer stop
) {}
