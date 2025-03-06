package org.orthologyapi.dto;

import lombok.Data;

@Data
public class CoordinatesDto {

    private String chromosome;
    private String start;
    private String stop;
}
