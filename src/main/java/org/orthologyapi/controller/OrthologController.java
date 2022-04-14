package org.orthologyapi.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.bytebuddy.implementation.bytecode.Throw;
import org.orthologyapi.dto.OrthologDto;
import org.orthologyapi.service.OrthologService;
import org.orthologyapi.service.ReportService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ortholog")
public class OrthologController {

    OrthologService orthologService;
    ReportService reportService;

    public OrthologController(OrthologService orthologService,
                              ReportService reportService) {
        this.orthologService = orthologService;
        this.reportService = reportService;
    }

    @GetMapping("/find_by_mouse_genes")
    public List<OrthologDto> findAllOneToOneOrthologsByMouseGeneList(
        @RequestParam(value = "genes") List<String> genes) throws Exception {

        if (genes.size() < 200) {
            return orthologService.findAllOneToOneOrthologsByMouseGeneList(genes);
        }
        throw new Exception("genes Parameter number can not be more than 200");
    }

    @GetMapping("/find_by_human_genes")
    public List<OrthologDto> findAllOneToOneOrthologsByHumanGeneList(
        @RequestParam(value = "genes") List<String> genes) throws Exception {
        if (genes.size() < 200) {
            return orthologService.findAllOneToOneOrthologsByHumanGeneList(genes);
        }
        throw new Exception("genes Parameter number can not be more than 200");
    }

    @GetMapping("/find_by_mgi_ids")
    public List<OrthologDto> findAllOneToOneOrthologsByMgiAccessionIdList(
        @RequestParam(value = "mgiIds") List<String> mgiIds) throws Exception {
        if (mgiIds.size() < 200) {
            return orthologService.findAllOneToOneOrthologsByMgiAccessionIdList(mgiIds);
        }
        throw new Exception("genes Parameter number can not be more than 200");
    }

    @GetMapping("/find_by_hgnc_ids")
    public List<OrthologDto> findAllOneToOneOrthologsByHgncAccessionIdList(
        @RequestParam(value = "hgncIds") List<String> hgncIds) throws Exception {
        if (hgncIds.size() < 200) {
            return orthologService.findAllOneToOneOrthologsByHgncAccessionIdList(hgncIds);
        }
        throw new Exception("genes Parameter number can not be more than 200");
    }

    @GetMapping(value = {"/find_all_orthologs"})
    public ResponseEntity findAllOrthologsPageable(
        final Pageable orthologPageable,
        final PagedResourcesAssembler orthologAssembler) {
        return orthologService.findAllOrthologsPageable(orthologPageable,orthologAssembler);
    }

    @GetMapping(value = {"/write_to_tsv_file"})
    @Transactional(readOnly = true)
    public void export(HttpServletResponse response) throws
        IOException {
        reportService.writeReport(response);
    }
}
