package org.orthologyapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class CoordinatesResponseDto {
    private List<CoordinatesDto> results;

}
