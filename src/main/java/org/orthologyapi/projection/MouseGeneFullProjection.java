package org.orthologyapi.projection;

public interface MouseGeneFullProjection {

    String getEnsemblChromosome();

    String getEnsemblGeneAccId();

    Long getEnsemblStart();

    Long getEnsemblStop();

    String getEnsemblStrand();

    Long getEntrezGeneAccId();

    String getGenomeBuild();

    String getMgiChromosome();

    String getMgiCm();

    String getMgiGeneAccId();

    Long getMgiStart();

    Long getMgiStop();

    String getMgiStrand();

    String getName();

    String getNcbiChromosome();

    Long getNcbiStart();

    Long getNcbiStop();

    String getNcbiStrand();

    String getSubtype();

    String getSymbol();

    String getType();
}
