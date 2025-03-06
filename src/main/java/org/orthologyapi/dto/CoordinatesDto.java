package org.orthologyapi.dto;

import lombok.Data;

@Data
public class CoordinatesDto {

    private String chromosome;
    private Integer start;
    private Integer stop;
}
