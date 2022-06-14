package org.orthologyapi.service;

import java.util.List;
import org.orthologyapi.descriptor.OrthologMapper;
import org.orthologyapi.dto.OrthologDto;
import org.orthologyapi.projection.OrthologProjection;
import org.orthologyapi.repository.OrthologRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class OrthologService {


    OrthologRepository orthologRepository;

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
}
