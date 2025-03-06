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
        OrthologDto orthologDto = new OrthologDto();
        orthologDto.setHumanGeneSymbol(orthologProjection.getHumanGeneSymbol());
        orthologDto.setHgncAccId(orthologProjection.getHgncAccId());
        orthologDto.setHumanSupportCountThreshold(orthologProjection.getHumanSupportCountThreshold());
        orthologDto.setHumanCategoryForThreshold(orthologProjection.getHumanCategoryForThreshold());
        orthologDto.setHumanOrthologsAboveThreshold(orthologProjection.getHumanOrthologsAboveThreshold());
        orthologDto.setCategory(orthologProjection.getCategory());
        orthologDto.setSupportCount(orthologProjection.getSupportCount());
        orthologDto.setIsMaxHumanToMouse(orthologProjection.getIsMaxHumanToMouse());
        orthologDto.setIsMaxMouseToHuman(orthologProjection.getIsMaxMouseToHuman());
        orthologDto.setMouseOrthologsAboveThreshold(orthologProjection.getMouseOrthologsAboveThreshold());
        orthologDto.setMouseCategoryForThreshold(orthologProjection.getMouseCategoryForThreshold());
        orthologDto.setMouseSupportCountThreshold(orthologProjection.getMouseSupportCountThreshold());
        orthologDto.setMgiGeneAccId(orthologProjection.getMgiGeneAccId());
        orthologDto.setMouseGeneSymbol(orthologProjection.getMouseGeneSymbol());
        return orthologDto;
    }


    public static EnsemblUrlDto ensemblUrlToDto(
            EnsemblUrlProjection ensemblUrlProjection) {
        EnsemblUrlDto ensemblUrlDto = new EnsemblUrlDto();
        ensemblUrlDto.setMgiGeneAccessionId(ensemblUrlProjection.getMgiGeneAccessionId());
        ensemblUrlDto.setEnsemblGeneAccId(ensemblUrlProjection.getEnsemblGeneAccId());
        return ensemblUrlDto;
    }

    public static CoordinatesDto coordinatesDto(
            CoordinatesProjection coordinatesProjection) {
        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setChromosome(coordinatesProjection.getChromosome());
        coordinatesDto.setStart(coordinatesProjection.getStart());
        coordinatesDto.setStop(coordinatesProjection.getStop());
        return coordinatesDto;
    }
}
