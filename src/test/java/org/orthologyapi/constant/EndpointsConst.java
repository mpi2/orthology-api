package org.orthologyapi.constant;

public class EndpointsConst {

    public static final String API_ORTHOLOG_FIND_BY_MOUSE_GENES_LINK =
        "http://localhost:8080/api/ortholog/find_by_mouse_genes?genes=A1cf";
    public static final String API_ORTHOLOG_FIND_BY_HUMAN_GENES_LINK =
        "http://localhost:8080/api/ortholog/find_by_human_genes?genes=A1CF";
    public static final String API_ORTHOLOG_FIND_BY_MGI_IDS_LINK =
        "http://localhost:8080/api/ortholog/find_by_mgi_ids?mgiIds=MGI:1917115";
    public static final String API_ORTHOLOG_ONE_TO_MANY_FIND_BY_MGI_IDS_LINK =
        "http://localhost:8080/api/ortholog/find_one_to_many_by_mgi_ids?mgiIds=MGI:1917115";
    public static final String API_ORTHOLOG_FIND_BY_HGNC_IDS_LINK =
        "http://localhost:8080/api/ortholog/find_by_hgnc_ids?hgncIds=HGNC:24086";
    public static final String API_ORTHOLOG_FIND_ALL_ORTHOLOGS =
        "http://localhost:8080/api/ortholog/find_all_orthologs";

}
