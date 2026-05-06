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
    public static final String FIND_MOUSE_GENES_BY_MGI_IDS_LINK =
        "http://localhost:8080/api/ortholog/mouse_genes/find_by_mgi_ids?mgiIds=MGI:1917115";
    public static final String FIND_MOUSE_GENES_BY_MGI_IDS_POST_LINK =
        "http://localhost:8080/api/ortholog/mouse_genes/find_by_mgi_ids";
    public static final String FIND_FULL_MOUSE_GENES_BY_MGI_IDS_LINK =
        "http://localhost:8080/api/ortholog/mouse_genes/find_full_by_mgi_ids?mgiIds=MGI:1917115,MGI:104537";
    public static final String FIND_FULL_MOUSE_GENES_BY_MGI_IDS_POST_LINK =
        "http://localhost:8080/api/ortholog/mouse_genes/find_full_by_mgi_ids";
    public static final String FIND_MOUSE_GENES_BY_SYMBOLS_OR_ACC_IDS_POST_LINK =
        "http://localhost:8080/api/ortholog/mouse_genes/find_by_symbols_or_acc_ids";
    public static final String FIND_MOUSE_GENE_BY_SYMBOL_OR_ACC_ID_LINK =
        "http://localhost:8080/api/ortholog/mouse_genes/find_by_symbol_or_acc_id?input=a1cf";
    public static final String FIND_MOUSE_GENES_BY_SYNONYM_LINK =
        "http://localhost:8080/api/ortholog/mouse_genes/find_by_synonym?synonym=acf";

}
