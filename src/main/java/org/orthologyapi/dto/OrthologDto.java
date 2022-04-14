package org.orthologyapi.dto;

import lombok.Data;

@Data
public class OrthologDto {
    
    String humanGeneSymbol;
    
    String hgncAccId;
    
    Long humanSupportCountThreshold;
    
    String humanCategoryForThreshold;
    
    Long humanOrthologsAboveThreshold;
    
    String category;
    
    Long supportCount;
    
    String isMaxHumanToMouse;
    
    String isMaxMouseToHuman;
    
    Long mouseOrthologsAboveThreshold;
    
    String mouseCategoryForThreshold;
    
    Long mouseSupportCountThreshold;
    
    String mgiGeneAccId;
    
    String MouseGeneSymbol;
}
