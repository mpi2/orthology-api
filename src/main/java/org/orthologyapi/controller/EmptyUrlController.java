package org.orthologyapi.controller;

import java.util.List;
import javax.naming.SizeLimitExceededException;
import org.orthologyapi.dto.OrthologDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmptyUrlController {

    @GetMapping("")
    public String emptyUrl() {
        return errorMessage();
    }

    @GetMapping("/api")
    public String onlyApiUrl() {
        return errorMessage();
    }

    @GetMapping("/api/ortholog")
    public String onlyApiAndOrthologyUrl() {
        return errorMessage();
    }

    private String errorMessage(){
        return "You entered missing Url. \n " +
            "Please enter one of following urls: \n" +
            "/api/ortholog/one_to_one/find_by_mouse_genes to find one to one orthologs by mouse genes\n" +
            "/api/ortholog/one_to_one/find_by_human_genes to find one to one orthologs by human genes\n" +
            "/api/ortholog/one_to_one/find_by_mgi_ids to find one to one orthologs by mouse gene ids\n" +
            "/api/ortholog/one_to_one/find_by_hgnc_ids to find one to one orthologs by human gene ids\n" +
            "/api/ortholog/find_by_mgi_ids to find orthologs by mouse gene ids\n" +
            "/api/ortholog/find_all to find all orthologs\n" +
            "/api/ortholog/write_to_tsv_file to download all orthologs as tsv file\n";
    }
}
