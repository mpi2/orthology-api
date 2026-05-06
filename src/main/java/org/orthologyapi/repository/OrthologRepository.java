package org.orthologyapi.repository;

import java.util.List;

import org.orthologyapi.entity.Ortholog;
import org.orthologyapi.projection.CoordinatesProjection;
import org.orthologyapi.projection.MouseGeneFullProjection;
import org.orthologyapi.projection.MouseGeneInfoProjection;
import org.orthologyapi.projection.OrthologProjection;
import org.orthologyapi.projection.EnsemblUrlProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrthologRepository extends PagingAndSortingRepository<Ortholog, Long> {

    @Query(value = "select h.symbol as humanGeneSymbol, " +
            "       h.hgnc_acc_id as hgncAccId, " +
            "       hmf.support_count_threshold as humanSupportCountThreshold, " +
            "       hmf.category_for_threshold as humanCategoryForThreshold, " +
            "       hmf.orthologs_above_threshold as humanOrthologsAboveThreshold, " +
            "       o.category, o.support_count as supportCount, " +
            "       o.is_max_human_to_mouse as isMaxHumanToMouse, " +
            "       o.is_max_mouse_to_human as isMaxMouseToHuman, " +
            "       mmf.orthologs_above_threshold as mouseOrthologsAboveThreshold, " +
            "       mmf.category_for_threshold as mouseCategoryForThreshold, " +
            "       mmf.support_count_threshold as mouseSupportCountThreshold, " +
            "       m.mgi_gene_acc_id as mgiGeneAccId, m.symbol as mouseGeneSymbol " +
            "from human_gene h, human_mapping_filter hmf, ortholog o, mouse_gene m, mouse_mapping_filter mmf " +
            "where h.id=hmf.human_gene_id and " +
            "hmf.support_count_threshold=5 and " +
            "hmf.category_for_threshold='one-to-one' and " +
            "h.id=o.human_gene_id and " +
            "o.support_count>=5 and " +
            "o.mouse_gene_id=m.id and " +
            "m.id=mmf.mouse_gene_id and " +
            "m.symbol IN :genes and " +
            "mmf.support_count_threshold=5 and " +
            "mmf.category_for_threshold='one-to-one' " +
            "order by " +
            "h.symbol asc;",
            nativeQuery = true)
    List<OrthologProjection> findOneToOneOrthologsByMouseGenes(@Param("genes") List<String> genes);

    @Query(value = "select h.symbol as humanGeneSymbol, " +
            "       h.hgnc_acc_id as hgncAccId, " +
            "       hmf.support_count_threshold as humanSupportCountThreshold, " +
            "       hmf.category_for_threshold as humanCategoryForThreshold, " +
            "       hmf.orthologs_above_threshold as humanOrthologsAboveThreshold, " +
            "       o.category, o.support_count as supportCount, " +
            "       o.is_max_human_to_mouse as isMaxHumanToMouse, " +
            "       o.is_max_mouse_to_human as isMaxMouseToHuman, " +
            "       mmf.orthologs_above_threshold as mouseOrthologsAboveThreshold, " +
            "       mmf.category_for_threshold as mouseCategoryForThreshold, " +
            "       mmf.support_count_threshold as mouseSupportCountThreshold, " +
            "       m.mgi_gene_acc_id as mgiGeneAccId, m.symbol as mouseGeneSymbol " +
            "from human_gene h, human_mapping_filter hmf, ortholog o, mouse_gene m, mouse_mapping_filter mmf " +
            "where h.id=hmf.human_gene_id and " +
            "hmf.support_count_threshold=5 and " +
            "hmf.category_for_threshold='one-to-one' and " +
            "h.id=o.human_gene_id and " +
            "o.support_count>=5 and " +
            "o.mouse_gene_id=m.id and " +
            "m.id=mmf.mouse_gene_id and " +
            "h.symbol IN :genes and " +
            "mmf.support_count_threshold=5 and " +
            "mmf.category_for_threshold='one-to-one' " +
            "order by " +
            "h.symbol asc;",
            nativeQuery = true)
    List<OrthologProjection> findOneToOneOrthologsByHumanGenes(@Param("genes") List<String> genes);

    @Query(value = "select h.symbol as humanGeneSymbol, " +
            "       h.hgnc_acc_id as hgncAccId, " +
            "       hmf.support_count_threshold as humanSupportCountThreshold, " +
            "       hmf.category_for_threshold as humanCategoryForThreshold, " +
            "       hmf.orthologs_above_threshold as humanOrthologsAboveThreshold, " +
            "       o.category, o.support_count as supportCount, " +
            "       o.is_max_human_to_mouse as isMaxHumanToMouse, " +
            "       o.is_max_mouse_to_human as isMaxMouseToHuman, " +
            "       mmf.orthologs_above_threshold as mouseOrthologsAboveThreshold, " +
            "       mmf.category_for_threshold as mouseCategoryForThreshold, " +
            "       mmf.support_count_threshold as mouseSupportCountThreshold, " +
            "       m.mgi_gene_acc_id as mgiGeneAccId, m.symbol as mouseGeneSymbol " +
            "from human_gene h, human_mapping_filter hmf, ortholog o, mouse_gene m, mouse_mapping_filter mmf " +
            "where h.id=hmf.human_gene_id and " +
            "hmf.support_count_threshold=5 and " +
            "hmf.category_for_threshold='one-to-one' and " +
            "h.id=o.human_gene_id and " +
            "o.support_count>=5 and " +
            "o.mouse_gene_id=m.id and " +
            "m.id=mmf.mouse_gene_id and " +
            "m.mgi_gene_acc_id IN :accessionIds and " +
            "mmf.support_count_threshold=5 and " +
            "mmf.category_for_threshold='one-to-one' " +
            "order by " +
            "h.symbol asc;",
            nativeQuery = true)
    List<OrthologProjection> findOneToOneOrthologsByMgiAccessionIds(
            @Param("accessionIds") List<String> accessionIds);

    @Query(value = "select h.symbol as humanGeneSymbol, " +
            "       h.hgnc_acc_id as hgncAccId, " +
            "       hmf.support_count_threshold as humanSupportCountThreshold, " +
            "       hmf.category_for_threshold as humanCategoryForThreshold, " +
            "       hmf.orthologs_above_threshold as humanOrthologsAboveThreshold, " +
            "       o.category, o.support_count as supportCount, " +
            "       o.is_max_human_to_mouse as isMaxHumanToMouse, " +
            "       o.is_max_mouse_to_human as isMaxMouseToHuman, " +
            "       mmf.orthologs_above_threshold as mouseOrthologsAboveThreshold, " +
            "       mmf.category_for_threshold as mouseCategoryForThreshold, " +
            "       mmf.support_count_threshold as mouseSupportCountThreshold, " +
            "       m.mgi_gene_acc_id as mgiGeneAccId, m.symbol as mouseGeneSymbol " +
            "from human_gene h, human_mapping_filter hmf, ortholog o, mouse_gene m, mouse_mapping_filter mmf " +
            "where h.id=hmf.human_gene_id and " +
            "hmf.support_count_threshold=5 and " +
            "h.id=o.human_gene_id and " +
            "o.support_count>=5 and " +
            "o.mouse_gene_id=m.id and " +
            "m.id=mmf.mouse_gene_id and " +
            "m.mgi_gene_acc_id IN :accessionIds and " +
            "mmf.support_count_threshold=5 " +
            "order by " +
            "h.symbol asc;",
            nativeQuery = true)
    List<OrthologProjection> findOrthologsByMgiAccessionIds(
            @Param("accessionIds") List<String> accessionIds);

    @Query(value = "select h.symbol as humanGeneSymbol, " +
            "       h.hgnc_acc_id as hgncAccId, " +
            "       hmf.support_count_threshold as humanSupportCountThreshold, " +
            "       hmf.category_for_threshold as humanCategoryForThreshold, " +
            "       hmf.orthologs_above_threshold as humanOrthologsAboveThreshold, " +
            "       o.category, o.support_count as supportCount, " +
            "       o.is_max_human_to_mouse as isMaxHumanToMouse, " +
            "       o.is_max_mouse_to_human as isMaxMouseToHuman, " +
            "       mmf.orthologs_above_threshold as mouseOrthologsAboveThreshold, " +
            "       mmf.category_for_threshold as mouseCategoryForThreshold, " +
            "       mmf.support_count_threshold as mouseSupportCountThreshold, " +
            "       m.mgi_gene_acc_id as mgiGeneAccId, m.symbol as mouseGeneSymbol " +
            "from human_gene h, human_mapping_filter hmf, ortholog o, mouse_gene m, mouse_mapping_filter mmf " +
            "where h.id=hmf.human_gene_id and " +
            "hmf.support_count_threshold=5 and " +
            "hmf.category_for_threshold='one-to-one' and " +
            "h.id=o.human_gene_id and " +
            "o.support_count>=5 and " +
            "o.mouse_gene_id=m.id and " +
            "m.id=mmf.mouse_gene_id and " +
            "h.hgnc_acc_id IN :accessionIds and " +
            "mmf.support_count_threshold=5 and " +
            "mmf.category_for_threshold='one-to-one' " +
            "order by " +
            "h.symbol asc;",
            nativeQuery = true)
    List<OrthologProjection> findOneToOneOrthologsByHgncAccessionIds(
            @Param("accessionIds") List<String> accessionIds);

    @Query(value = "select h.symbol as humanGeneSymbol, " +
            "       h.hgnc_acc_id as hgncAccId, " +
            "       hmf.support_count_threshold as humanSupportCountThreshold, " +
            "       hmf.category_for_threshold as humanCategoryForThreshold, " +
            "       hmf.orthologs_above_threshold as humanOrthologsAboveThreshold, " +
            "       o.category, o.support_count as supportCount, " +
            "       o.is_max_human_to_mouse as isMaxHumanToMouse, " +
            "       o.is_max_mouse_to_human as isMaxMouseToHuman, " +
            "       mmf.orthologs_above_threshold as mouseOrthologsAboveThreshold, " +
            "       mmf.category_for_threshold as mouseCategoryForThreshold, " +
            "       mmf.support_count_threshold as mouseSupportCountThreshold, " +
            "       m.mgi_gene_acc_id as mgiGeneAccId, m.symbol as mouseGeneSymbol " +
            "from human_gene h, human_mapping_filter hmf, ortholog o, mouse_gene m, mouse_mapping_filter mmf " +
            "where h.id=hmf.human_gene_id and " +
            "hmf.support_count_threshold=5 and " +
            "h.id=o.human_gene_id and " +
            "o.support_count>=5 and " +
            "o.mouse_gene_id=m.id and " +
            "m.id=mmf.mouse_gene_id and " +
            "mmf.support_count_threshold=5 " +
            "order by " +
            "h.symbol asc;",
            nativeQuery = true)
    List<OrthologProjection> findAllOrthologsForTsvFile();

    @Query(value = "select h.symbol as humanGeneSymbol, " +
            "       h.hgnc_acc_id as hgncAccId, " +
            "       hmf.support_count_threshold as humanSupportCountThreshold, " +
            "       hmf.category_for_threshold as humanCategoryForThreshold, " +
            "       hmf.orthologs_above_threshold as humanOrthologsAboveThreshold, " +
            "       o.category, o.support_count as supportCount, " +
            "       o.is_max_human_to_mouse as isMaxHumanToMouse, " +
            "       o.is_max_mouse_to_human as isMaxMouseToHuman, " +
            "       mmf.orthologs_above_threshold as mouseOrthologsAboveThreshold, " +
            "       mmf.category_for_threshold as mouseCategoryForThreshold, " +
            "       mmf.support_count_threshold as mouseSupportCountThreshold, " +
            "       m.mgi_gene_acc_id as mgiGeneAccId, m.symbol as mouseGeneSymbol " +
            "from human_gene h, human_mapping_filter hmf, ortholog o, mouse_gene m, mouse_mapping_filter mmf " +
            "where h.id=hmf.human_gene_id and " +
            "hmf.support_count_threshold=5 and " +
            "hmf.category_for_threshold='one-to-one' and " +
            "h.id=o.human_gene_id and " +
            "o.support_count>=5 and " +
            "o.mouse_gene_id=m.id and " +
            "m.id=mmf.mouse_gene_id and " +
            "mmf.support_count_threshold=5 and " +
            "mmf.category_for_threshold='one-to-one' " +
            "order by " +
            "h.symbol asc;",
            nativeQuery = true)
    List<OrthologProjection> findOneToOneAllOrthologsForTsvFile();


    @Query(value = "select h.symbol as humanGeneSymbol, " +
            "       h.hgnc_acc_id as hgncAccId, " +
            "       hmf.support_count_threshold as humanSupportCountThreshold, " +
            "       hmf.category_for_threshold as humanCategoryForThreshold, " +
            "       hmf.orthologs_above_threshold as humanOrthologsAboveThreshold, " +
            "       o.category, o.support_count as supportCount, " +
            "       o.is_max_human_to_mouse as isMaxHumanToMouse, " +
            "       o.is_max_mouse_to_human as isMaxMouseToHuman, " +
            "       mmf.orthologs_above_threshold as mouseOrthologsAboveThreshold, " +
            "       mmf.category_for_threshold as mouseCategoryForThreshold, " +
            "       mmf.support_count_threshold as mouseSupportCountThreshold, " +
            "       m.mgi_gene_acc_id as mgiGeneAccId, m.symbol as mouseGeneSymbol " +
            "from human_gene h, human_mapping_filter hmf, ortholog o, mouse_gene m, mouse_mapping_filter mmf " +
            "where h.id=hmf.human_gene_id and " +
            "hmf.support_count_threshold=5 and " +
            "(m.subtype='protein coding gene' or m.subtype='miRNA gene') and " +
            "hmf.category_for_threshold='one-to-one' and " +
            "h.id=o.human_gene_id and " +
            "o.support_count>=5 and " +
            "o.mouse_gene_id=m.id and " +
            "m.id=mmf.mouse_gene_id and " +
            "mmf.support_count_threshold=5 and " +
            "mmf.category_for_threshold='one-to-one' " +
            "order by " +
            "h.symbol asc;",
            nativeQuery = true)
    List<OrthologProjection> findOneToOneImpcOrthologsForTsvFile();


    @Query(value = "select h.symbol as humanGeneSymbol, " +
            "       h.hgnc_acc_id as hgncAccId, " +
            "       hmf.support_count_threshold as humanSupportCountThreshold, " +
            "       hmf.category_for_threshold as humanCategoryForThreshold, " +
            "       hmf.orthologs_above_threshold as humanOrthologsAboveThreshold, " +
            "       o.category, o.support_count as supportCount, " +
            "       o.is_max_human_to_mouse as isMaxHumanToMouse, " +
            "       o.is_max_mouse_to_human as isMaxMouseToHuman, " +
            "       mmf.orthologs_above_threshold as mouseOrthologsAboveThreshold, " +
            "       mmf.category_for_threshold as mouseCategoryForThreshold, " +
            "       mmf.support_count_threshold as mouseSupportCountThreshold, " +
            "       m.mgi_gene_acc_id as mgiGeneAccId, m.symbol as mouseGeneSymbol " +
            "from human_gene h, human_mapping_filter hmf, ortholog o, mouse_gene m, mouse_mapping_filter mmf " +
            "where h.id=hmf.human_gene_id and " +
            "hmf.support_count_threshold=5 and " +
            "h.id=o.human_gene_id and " +
            "o.support_count>=5 and " +
            "o.mouse_gene_id=m.id and " +
            "m.id=mmf.mouse_gene_id and " +
            "mmf.support_count_threshold=5 " +
            "order by " +
            "h.symbol asc",
            nativeQuery = true)
    Page<OrthologProjection> findAllOrthologsPageable(Pageable pageable);


    @Query(value = "select " +
            "m.mgi_gene_acc_id as mgiGeneAccId, " +
            "m.ensembl_gene_acc_id as ensemblGeneAccId " +
            "from mouse_gene m " +
            "where ensembl_gene_acc_id is not null " +
            "and mgi_gene_acc_id is not null",
            nativeQuery = true)
    List<EnsemblUrlProjection> findAllEnsemblIds();

    @Query(value = "select CONCAT('chr', mgi_chromosome) as chromosome,mgi_start as start ,mgi_stop as stop from mouse_gene where upper(symbol) = upper(:symbol)",
            nativeQuery = true)
    List<CoordinatesProjection> findCoordinatesBySymbol(
            @Param("symbol") String symbol);

    @Query(value = "select CONCAT('chr', mgi_chromosome) as chromosome,mgi_start as start ,mgi_stop as stop from mouse_gene where upper(mgi_gene_acc_id) = upper(:mgi)",
            nativeQuery = true)
    List<CoordinatesProjection> findCoordinatesByMgi(String mgi);

    @Query(value = "select " +
            "m.ensembl_chromosome as ensemblChromosome, " +
            "m.ensembl_gene_acc_id as ensemblGeneAccId, " +
            "m.ensembl_start as ensemblStart, " +
            "m.ensembl_stop as ensemblStop, " +
            "m.ensembl_strand as ensemblStrand, " +
            "m.mgi_gene_acc_id as mgiGeneAccId, " +
            "m.symbol as symbol " +
            "from mouse_gene m " +
            "where m.mgi_gene_acc_id IN :mgiIds " +
            "order by m.symbol asc",
            nativeQuery = true)
    List<MouseGeneInfoProjection> findMouseGenesByMgiAccessionIds(
            @Param("mgiIds") List<String> mgiIds);

    String FULL_MOUSE_GENE_COLUMNS =
            "m.ensembl_chromosome as ensemblChromosome, " +
            "m.ensembl_gene_acc_id as ensemblGeneAccId, " +
            "m.ensembl_start as ensemblStart, " +
            "m.ensembl_stop as ensemblStop, " +
            "m.ensembl_strand as ensemblStrand, " +
            "m.entrez_gene_acc_id as entrezGeneAccId, " +
            "m.genome_build as genomeBuild, " +
            "m.mgi_chromosome as mgiChromosome, " +
            "m.mgi_cm as mgiCm, " +
            "m.mgi_gene_acc_id as mgiGeneAccId, " +
            "m.mgi_start as mgiStart, " +
            "m.mgi_stop as mgiStop, " +
            "m.mgi_strand as mgiStrand, " +
            "m.name as name, " +
            "m.ncbi_chromosome as ncbiChromosome, " +
            "m.ncbi_start as ncbiStart, " +
            "m.ncbi_stop as ncbiStop, " +
            "m.ncbi_strand as ncbiStrand, " +
            "m.subtype as subtype, " +
            "m.symbol as symbol, " +
            "m.type as type ";

    @Query(value = "select " + FULL_MOUSE_GENE_COLUMNS +
            "from mouse_gene m " +
            "where m.mgi_gene_acc_id IN :mgiIds " +
            "order by m.symbol asc",
            nativeQuery = true)
    List<MouseGeneFullProjection> findFullMouseGenesByMgiAccessionIds(
            @Param("mgiIds") List<String> mgiIds);

    @Query(value = "select " + FULL_MOUSE_GENE_COLUMNS +
            "from mouse_gene m " +
            "where m.symbol IN :inputs " +
            "   or m.mgi_gene_acc_id IN :inputs " +
            "order by m.symbol asc",
            nativeQuery = true)
    List<MouseGeneFullProjection> findFullMouseGenesBySymbolsOrAccIds(
            @Param("inputs") List<String> inputs);

    @Query(value = "select " + FULL_MOUSE_GENE_COLUMNS +
            "from mouse_gene m " +
            "where LOWER(m.symbol) = LOWER(:input) " +
            "   or LOWER(m.mgi_gene_acc_id) = LOWER(:input) " +
            "order by m.symbol asc",
            nativeQuery = true)
    List<MouseGeneFullProjection> findFullMouseGenesBySymbolOrAccId(
            @Param("input") String input);

    @Query(value = "select distinct " + FULL_MOUSE_GENE_COLUMNS +
            "from mouse_gene m " +
            "join mouse_gene_synonym_relation r on r.mouse_gene_id = m.id " +
            "join mouse_gene_synonym s on s.id = r.mouse_gene_synonym_id " +
            "where LOWER(s.synonym) = LOWER(:synonym) " +
            "order by m.symbol asc",
            nativeQuery = true)
    List<MouseGeneFullProjection> findFullMouseGenesBySynonym(
            @Param("synonym") String synonym);
}
