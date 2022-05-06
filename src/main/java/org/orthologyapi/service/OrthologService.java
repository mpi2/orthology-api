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

    public List<OrthologDto> findAllOneToOneOrthologsByMouseGeneList(List<String> genes) {
        return orthologRepository.findAllOrthologsByMouseGeneList(genes).stream()
            .map(OrthologMapper::orthologToDto).toList();
    }

    public List<OrthologDto> findAllOneToOneOrthologsByHumanGeneList(List<String> genes) {
        return orthologRepository.findAllOrthologsByHumanGeneList(genes).stream()
            .map(OrthologMapper::orthologToDto).toList();
    }

    public List<OrthologDto> findAllOneToOneOrthologsByMgiAccessionIdList(
        List<String> mgiAccessionIds) {
        return orthologRepository
            .findAllOrthologsByMgiAccessionIdList(mgiAccessionIds).stream()
            .map(OrthologMapper::orthologToDto).toList();
    }

    public List<OrthologDto> findAllOneToOneOrthologsByHgncAccessionIdList(
        List<String> hgncAccessionIds) {
        return orthologRepository
            .findAllOrthologsByHgncAccessionIdList(hgncAccessionIds).stream()
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
