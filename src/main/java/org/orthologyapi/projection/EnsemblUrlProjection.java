package org.orthologyapi.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EnsemblUrlProjection {


    @Value("#{target.mgiGeneAccId}")
    String getMgiGeneAccessionId();

    @Value("#{target.ensemblGeneAccId}")
    String getEnsemblGeneAccId();
}
