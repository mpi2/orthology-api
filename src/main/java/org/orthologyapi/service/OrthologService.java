package org.orthologyapi.service;

import java.util.List;

import org.orthologyapi.descriptor.OrthologMapper;
import org.orthologyapi.dto.CoordinatesDto;
import org.orthologyapi.dto.OrthologDto;
import org.orthologyapi.dto.EnsemblUrlDto;
import org.orthologyapi.projection.CoordinatesProjection;
import org.orthologyapi.projection.OrthologProjection;
import org.orthologyapi.projection.EnsemblUrlProjection;
import org.orthologyapi.repository.OrthologRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class OrthologService {


    private final OrthologRepository orthologRepository;

    public OrthologService(OrthologRepository orthologRepository) {
        this.orthologRepository = orthologRepository;
    }

    public List<OrthologDto> findAllOneToOneOrthologsByMouseGenes(List<String> genes) {
        return orthologRepository.findOneToOneOrthologsByMouseGenes(genes).stream()
                .map(OrthologMapper::orthologToDto).toList();
    }

    public List<OrthologDto> findAllOneToOneOrthologsByHumanGenes(List<String> genes) {
        return orthologRepository.findOneToOneOrthologsByHumanGenes(genes).stream()
                .map(OrthologMapper::orthologToDto).toList();
    }

    public List<OrthologDto> findAllOneToOneOrthologsByMgiAccessionIds(
            List<String> mgiAccessionIds) {
        return orthologRepository
                .findOneToOneOrthologsByMgiAccessionIds(mgiAccessionIds).stream()
                .map(OrthologMapper::orthologToDto).toList();
    }

    public List<OrthologDto> findAllOneToManyOrthologsByMgiAccessionIds(
            List<String> mgiAccessionIds) {
        return orthologRepository
                .findOrthologsByMgiAccessionIds(mgiAccessionIds).stream()
                .map(OrthologMapper::orthologToDto).toList();
    }

    public List<OrthologDto> findAllOneToOneOrthologsByHgncAccessionIds(
            List<String> hgncAccessionIds) {
        return orthologRepository
                .findOneToOneOrthologsByHgncAccessionIds(hgncAccessionIds).stream()
                .map(OrthologMapper::orthologToDto).toList();
    }

    public ResponseEntity findAllOrthologsPageable(final Pageable orthologPageable,
                                                   final PagedResourcesAssembler orthologAssembler) {

        Page<OrthologProjection> orthologProjectionPage =
                orthologRepository.findAllOrthologsPageable(orthologPageable);

        Page<OrthologDto> orthologDtosPage =
                orthologProjectionPage.map(OrthologMapper::orthologToDto);


        return new ResponseEntity<>(orthologAssembler.toModel(orthologDtosPage), HttpStatus.OK);
    }

    public List<EnsemblUrlDto> findAllEnsemblIds() {

        List<EnsemblUrlProjection> ensemblUrlProjection =
                orthologRepository.findAllEnsemblIds();

        return
                ensemblUrlProjection.stream().map(OrthologMapper::ensemblUrlToDto).toList();
    }

    public List<CoordinatesDto> getCoordinatesBySymbol(String symbol) {

        List<CoordinatesProjection> coordinatesProjections = orthologRepository.findCoordinatesBySymbol(symbol);

       return coordinatesProjections.stream().map(OrthologMapper::coordinatesDto).toList();


    }
}
