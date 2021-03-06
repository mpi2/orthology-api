package org.orthologyapi.constant;

public class EndpointsConst {

    public static final String FIND_ONE_TO_ONE_BY_MOUSE_GENES_LINK =
        "http://localhost:8080/api/ortholog/one_to_one/find_by_mouse_genes?genes=A1cf";
    public static final String FIND_ONE_TO_ONE_BY_HUMAN_GENES_LINK =
        "http://localhost:8080/api/ortholog/one_to_one/find_by_human_genes?genes=A1CF";
    public static final String FIND_ONE_ONE_BY_MGI_IDS_LINK =
        "http://localhost:8080/api/ortholog/one_to_one/find_by_mgi_ids?mgiIds=MGI:1917115";
    public static final String FIND_BY_MGI_IDS_LINK =
        "http://localhost:8080/api/ortholog/find_all_by_mgi_ids?mgiIds=MGI:1917115";
    public static final String FIND_ONE_TO_ONE_BY_HGNC_IDS_LINK =
        "http://localhost:8080/api/ortholog/one_to_one/find_by_hgnc_ids?hgncIds=HGNC:24086";
    public static final String FIND_ALL_ORTHOLOGS_LINK =
        "http://localhost:8080/api/ortholog/find_all";

}
