package org.orthologyapi.dto;

import lombok.Data;

@Data
public class EnsemblUrlDto {
    
    String mgiGeneAccId;
    
    String mouseGeneSymbol;

    String ensemblGeneAccId;
}
