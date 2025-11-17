package org.orthologyapi.projection;

import org.springframework.beans.factory.annotation.Value;

public interface CoordinatesProjection {


    @Value("#{target.chromosome}")
    String getChromosome();

    @Value("#{target.start}")
    String getStart();

    @Value("#{target.stop}")
    String getStop();
}
