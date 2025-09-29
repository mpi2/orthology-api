package org.orthologyapi.dto;

public record OrthologRecord(
    Long id,
    String support,
    String supportRaw,
    Long supportCount,
    String category,
    String isMaxHumanToMouse,
    String isMaxMouseToHuman,
    Long mouseGeneId,
    Long humanGeneId
) {}
