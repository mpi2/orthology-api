package org.orthologyapi.descriptor;

import org.orthologyapi.dto.CoordinatesDto;
import org.orthologyapi.dto.EnsemblUrlDto;
import org.orthologyapi.dto.OrthologDto;
import org.orthologyapi.projection.CoordinatesProjection;
import org.orthologyapi.projection.EnsemblUrlProjection;
import org.orthologyapi.projection.OrthologProjection;

public class OrthologMapper {

    public static OrthologDto orthologToDto(
            OrthologProjection orthologProjection) {
        return new OrthologDto(
            orthologProjection.getHumanGeneSymbol(),
            orthologProjection.getHgncAccId(),
            orthologProjection.getHumanSupportCountThreshold(),
            orthologProjection.getHumanCategoryForThreshold(),
            orthologProjection.getHumanOrthologsAboveThreshold(),
            orthologProjection.getCategory(),
            orthologProjection.getSupportCount(),
            orthologProjection.getIsMaxHumanToMouse(),
            orthologProjection.getIsMaxMouseToHuman(),
            orthologProjection.getMouseOrthologsAboveThreshold(),
            orthologProjection.getMouseCategoryForThreshold(),
            orthologProjection.getMouseSupportCountThreshold(),
            orthologProjection.getMgiGeneAccId(),
            orthologProjection.getMouseGeneSymbol()
        );
    }


    public static EnsemblUrlDto ensemblUrlToDto(
            EnsemblUrlProjection ensemblUrlProjection) {
        return new EnsemblUrlDto(
            ensemblUrlProjection.getMgiGeneAccessionId(),
            ensemblUrlProjection.getEnsemblGeneAccId()
        );
    }

    public static CoordinatesDto coordinatesDto(
            CoordinatesProjection coordinatesProjection) {
        return new CoordinatesDto(
            coordinatesProjection.getChromosome(),
            Integer.parseInt(coordinatesProjection.getStart()),
            Integer.parseInt(coordinatesProjection.getStop())
        );
    }
}
