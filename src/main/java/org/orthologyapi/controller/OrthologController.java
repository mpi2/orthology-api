package org.orthologyapi.controller;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import org.orthologyapi.dto.CoordinatesDto;
import org.orthologyapi.dto.CoordinatesResponseDto;
import org.orthologyapi.dto.EnsemblUrlDto;
import org.orthologyapi.dto.OrthologDto;
import org.orthologyapi.service.OrthologService;
import org.orthologyapi.service.ReportService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.naming.SizeLimitExceededException;

@RestController
@RequestMapping("api/ortholog")
public class OrthologController {

    public static final int PARAMETER_SIZE = 651;
    private final OrthologService orthologService;
    private final ReportService reportService;

    public OrthologController(OrthologService orthologService,
                              ReportService reportService) {
        this.orthologService = orthologService;
        this.reportService = reportService;
    }

    @GetMapping("/one_to_one/find_by_mouse_genes")
    public List<OrthologDto> findAllOneToOneOrthologsByMouseGenes(
            @RequestParam(value = "genes") List<String> genes) throws SizeLimitExceededException {

        if (genes.size() < PARAMETER_SIZE) {
            return orthologService.findAllOneToOneOrthologsByMouseGenes(genes);
        }
        throw new SizeLimitExceededException("Mouse genes parameters number can not be more than " + PARAMETER_SIZE);
    }

    @GetMapping("/one_to_one/find_by_human_genes")
    public List<OrthologDto> findAllOneToOneOrthologsByHumanGenes(
            @RequestParam(value = "genes") List<String> genes) throws SizeLimitExceededException {
        if (genes.size() < PARAMETER_SIZE) {
            return orthologService.findAllOneToOneOrthologsByHumanGenes(genes);
        }
        throw new SizeLimitExceededException("Human genes parameters number can not be more than " + PARAMETER_SIZE);
    }

    @GetMapping("/one_to_one/find_by_mgi_ids")
    public List<OrthologDto> findAllOneToOneOrthologsByMgiAccessionIds(
            @RequestParam(value = "mgiIds") List<String> mgiIds) throws SizeLimitExceededException {
        if (mgiIds.size() < PARAMETER_SIZE) {
            return orthologService.findAllOneToOneOrthologsByMgiAccessionIds(mgiIds);
        }
        throw new SizeLimitExceededException("Mgi accession ids Parameter number can not be more than " + PARAMETER_SIZE);
    }

    @GetMapping("/find_all_by_mgi_ids")
    public List<OrthologDto> findOrthologsByMgiAccessionIds(
            @RequestParam(value = "mgiIds") List<String> mgiIds) throws SizeLimitExceededException {
        if (mgiIds.size() < PARAMETER_SIZE) {
            return orthologService.findAllOneToManyOrthologsByMgiAccessionIds(mgiIds);
        }
        throw new SizeLimitExceededException("Mgi accession ids Parameter number can not be more than " + PARAMETER_SIZE);
    }

    @GetMapping("/one_to_one/find_by_hgnc_ids")
    public List<OrthologDto> findAllOneToOneOrthologsByHgncAccessionIds(
            @RequestParam(value = "hgncIds") List<String> hgncIds) throws SizeLimitExceededException {
        if (hgncIds.size() < PARAMETER_SIZE) {
            return orthologService.findAllOneToOneOrthologsByHgncAccessionIds(hgncIds);
        }
        throw new SizeLimitExceededException("Hgnc accession ids number can not be more than " + PARAMETER_SIZE);
    }

    @GetMapping(value = {"/find_all"})
    public ResponseEntity findAllOrthologsPageable(
            final Pageable orthologPageable,
            final PagedResourcesAssembler orthologAssembler) {
        return orthologService.findAllOrthologsPageable(orthologPageable, orthologAssembler);
    }

    @GetMapping(value = {"/write_to_tsv_file"})
    @Transactional(readOnly = true)
    public boolean exportAll(HttpServletResponse response) throws
            IOException {
        return reportService.writeReportForAllOthologs(response);
    }

    @GetMapping(value = {"/one_to_one/all/write_to_tsv_file"})
    @Transactional(readOnly = true)
    public boolean exportAllOneToOne(HttpServletResponse response) throws
            IOException {
        return reportService.writeReportForOneToOneAllOrthologs(response);
    }


    @GetMapping(value = {"/one_to_one/impc/write_to_tsv_file"})
    @Transactional(readOnly = true)
    public boolean exportOneToOneImpc(HttpServletResponse response) throws
            IOException {
        return reportService.writeReportForOneToOneImpcOrthologs(response);
    }

    @GetMapping("/find_all_ensembl_ids")
    public List<EnsemblUrlDto> findOrthologsByMgiAccessionIds() {
        return orthologService.findAllEnsemblIds();

    }

    @CrossOrigin
    @GetMapping("/get-coordinates/search")
    public CoordinatesResponseDto findCoordinatesByGeneQuery(
            @RequestParam(value = "geneQuery") String geneQuery) {
        List<CoordinatesDto> coordinates;
        if (geneQuery.toUpperCase().contains("MGI:")) {
            coordinates = orthologService.getCoordinatesByMgi(geneQuery);
        } else {
            coordinates = orthologService.getCoordinatesBySymbol(geneQuery);
        }
        return new CoordinatesResponseDto(coordinates);

    }
}
