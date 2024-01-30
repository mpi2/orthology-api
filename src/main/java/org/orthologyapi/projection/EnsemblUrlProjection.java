package org.orthologyapi.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EnsemblUrlProjection {


    @Value("#{target.mgiGeneAccId}")
    String getMgiGeneAccId();

    @Value("#{target.ensemblGeneAccId}")
    String getEnsemblGeneAccId();
}
