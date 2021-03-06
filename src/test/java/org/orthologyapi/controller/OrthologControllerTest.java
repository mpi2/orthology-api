package org.orthologyapi.controller;

import static org.orthologyapi.constant.DBSetupFilesPathsConst.DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML;
import static org.orthologyapi.constant.DBSetupFilesPathsConst.EXPECTED_All_ORTHOLOGS_PAGEABLE_JSON;
import static org.orthologyapi.constant.DBSetupFilesPathsConst.EXPECTED_ORTHOLOGS_JSON;
import static org.orthologyapi.constant.DBSetupFilesPathsConst.INTEGRATION_TESTS_RESOURCE_PATH;
import static org.orthologyapi.constant.EndpointsConst.FIND_ALL_ORTHOLOGS_LINK;
import static org.orthologyapi.constant.EndpointsConst.FIND_ONE_TO_ONE_BY_HGNC_IDS_LINK;
import static org.orthologyapi.constant.EndpointsConst.FIND_ONE_TO_ONE_BY_HUMAN_GENES_LINK;
import static org.orthologyapi.constant.EndpointsConst.FIND_ONE_ONE_BY_MGI_IDS_LINK;
import static org.orthologyapi.constant.EndpointsConst.FIND_ONE_TO_ONE_BY_MOUSE_GENES_LINK;
import static org.orthologyapi.constant.EndpointsConst.FIND_BY_MGI_IDS_LINK;
import static org.orthologyapi.constant.FolderNamesConst.ONE_TO_ONE_BY_HGNC_ACCESSION_ID;
import static org.orthologyapi.constant.FolderNamesConst.ONE_TO_ONE_BY_HUMAN_GENES;
import static org.orthologyapi.constant.FolderNamesConst.ONE_TO_ONE_BY_MGI_ACCESSION_ID;
import static org.orthologyapi.constant.FolderNamesConst.ONE_TO_ONE_BY_MOUSE_GENES;
import static org.orthologyapi.constant.FolderNamesConst.FIND_ALL_ORTHOLOGS;
import static org.orthologyapi.constant.FolderNamesConst.All_BY_MGI_ACCESSION_ID;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.orthologyapi.conf.ControllerTestTemplate;
import org.orthologyapi.conf.RestCaller;
import org.orthologyapi.conf.TestResourceLoader;
import org.orthologyapi.descriptor.OrthologyFieldsDescriptors;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.ResultHandler;


class OrthologControllerTest extends ControllerTestTemplate {

    public static final String EMPTY_PREFIX = "";
    public static final String EMBEDDED_ORTHOLOG_DTO_LIST_PREFIX = "_embedded.orthologDtoList.";


    private RestCaller restCaller;

    @BeforeEach
    public void setup() {
        restCaller = new RestCaller(mvc());

    }


    @Test
    @DatabaseSetup(DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML)
    @DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML)
    @DisplayName("Test One To One Orthologs By Mouse Gene List")
    void findAllOneToOneOrthologsByMouseGeneList() throws Exception {

        assertOrthologyEndpoints(FIND_ONE_TO_ONE_BY_MOUSE_GENES_LINK, ONE_TO_ONE_BY_MOUSE_GENES);
    }

    @Test
    @DatabaseSetup(DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML)
    @DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML)
    @DisplayName("Test One To OneOrthologs By Human Gene List")
    void findAllOneToOneOrthologsByHumanGeneList() throws Exception {

        assertOrthologyEndpoints(FIND_ONE_TO_ONE_BY_HUMAN_GENES_LINK, ONE_TO_ONE_BY_HUMAN_GENES);
    }

    @Test
    @DatabaseSetup(DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML)
    @DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML)
    @DisplayName("Test One To One Orthologs By Mgi Accession Id List")
    void findAllOneToOneOrthologsByMgiAccessionIdList() throws Exception {

        assertOrthologyEndpoints(FIND_ONE_ONE_BY_MGI_IDS_LINK, ONE_TO_ONE_BY_MGI_ACCESSION_ID);
    }

    @Test
    @DatabaseSetup(DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML)
    @DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML)
    @DisplayName("Test Orthologs By Mgi Accession Id List")
    void findAllOneToManyOrthologsByMgiAccessionIdList() throws Exception {

        assertOrthologyEndpoints(FIND_BY_MGI_IDS_LINK, All_BY_MGI_ACCESSION_ID);
    }

    @Test
    @DatabaseSetup(DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML)
    @DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML)
    @DisplayName("Test One To One Orthologs By Hgnc Accession Id List")
    void findAllOneToOneOrthologsByHgncAccessionIdList() throws Exception {

        assertOrthologyEndpoints(FIND_ONE_TO_ONE_BY_HGNC_IDS_LINK, ONE_TO_ONE_BY_HGNC_ACCESSION_ID);
    }


    @Test
    @DatabaseSetup(DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML)
    @DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = DBUNIT_ORTHOLOGY_ORTHOLOGY_DB_XML)
    @DisplayName("Test All Orthologs Pageable")
    void findAllOrthologsPageable() throws Exception {
        String contentAsString =
            restCaller.executeGetAndDocument(FIND_ALL_ORTHOLOGS_LINK,
                documentOrthologyEndPoints(EMBEDDED_ORTHOLOG_DTO_LIST_PREFIX, FIND_ALL_ORTHOLOGS));

        String expectedOutputAsString =
            loadExpectedResponseFromResource(EXPECTED_All_ORTHOLOGS_PAGEABLE_JSON);

        JSONAssert.assertEquals(expectedOutputAsString, contentAsString, JSONCompareMode.STRICT);
    }

    private void assertOrthologyEndpoints(String url, String folderName)
        throws Exception {
        String contentAsString =
            restCaller
                .executeGetAndDocument(url, documentOrthologyEndPoints(EMPTY_PREFIX, folderName));

        String expectedOutputAsString =
            loadExpectedResponseFromResource(EXPECTED_ORTHOLOGS_JSON);

        JSONAssert.assertEquals(expectedOutputAsString, contentAsString, JSONCompareMode.STRICT);
    }


    private ResultHandler documentOrthologyEndPoints(String prefix, String endpoint) {
        List<FieldDescriptor> orthologyFieldsDescriptions =
            OrthologyFieldsDescriptors.getOrthologyFieldsDescriptions(prefix);
        return document(endpoint, responseFields(orthologyFieldsDescriptions));
    }

    private String loadExpectedResponseFromResource(String resourceName)
        throws IOException {
        String completeResourcePath = INTEGRATION_TESTS_RESOURCE_PATH + resourceName;
        return TestResourceLoader.loadJsonFromResource(completeResourcePath);
    }
}