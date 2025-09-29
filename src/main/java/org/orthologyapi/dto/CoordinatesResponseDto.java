package org.orthologyapi.dto;

import java.util.List;

public record CoordinatesResponseDto(
    List<CoordinatesDto> results
) {}
