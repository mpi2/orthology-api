package org.orthologyapi.projection;

public interface MouseGeneInfoProjection {

    String getEnsemblChromosome();

    String getEnsemblGeneAccId();

    Long getEnsemblStart();

    Long getEnsemblStop();

    String getEnsemblStrand();

    String getMgiGeneAccId();

    String getSymbol();
}
