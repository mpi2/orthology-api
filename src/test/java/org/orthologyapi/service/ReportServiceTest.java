package org.orthologyapi.service;

import static org.mockito.Mockito.mock;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.orthologyapi.projection.OrthologProjection;
import org.orthologyapi.repository.OrthologRepository;

@ExtendWith(MockitoExtension.class)
class ReportServiceTest {
    @Mock
    HttpServletResponse mockResponse;
    @Mock
    OrthologRepository orthologRepository;
    @InjectMocks
    ReportService reportService;

    @BeforeEach
    public void setUp() {
        mockResponse = mock(HttpServletResponse.class);
    }

    @Test
    void writeReportForAllOrthologs() throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Mockito.when(mockResponse.getWriter()).thenReturn(printWriter);
        Mockito.when(orthologRepository.findAllOrthologsForTsvFile())
            .thenReturn(orthologTestData());
        boolean actual = reportService.writeReportForAllOthologs(mockResponse);
        Assertions.assertTrue(actual);
    }

    @Test
    void writeReportForOneToOneOrthologs() throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Mockito.when(mockResponse.getWriter()).thenReturn(printWriter);
        Mockito.when(orthologRepository.findOneToOneImpcOrthologsForTsvFile())
            .thenReturn(orthologTestData());
        boolean actual = reportService.writeReportForOneToOneImpcOrthologs(mockResponse);
        Assertions.assertTrue(actual);
    }

    private List<OrthologProjection> orthologTestData() {
        List<OrthologProjection> orthologProjections = new ArrayList<>();
        orthologProjections.add(new OrthologProjection() {
            @Override
            public String getHumanGeneSymbol() {
                return "A1CF";
            }

            @Override
            public String getHgncAccId() {
                return "HGNC:24086";
            }

            @Override
            public Long getHumanSupportCountThreshold() {
                return 5L;
            }

            @Override
            public String getHumanCategoryForThreshold() {
                return "one-to-one";
            }

            @Override
            public Long getHumanOrthologsAboveThreshold() {
                return 1L;
            }

            @Override
            public String getCategory() {
                return "GOOD";
            }

            @Override
            public Long getSupportCount() {
                return 11L;
            }

            @Override
            public String getIsMaxHumanToMouse() {
                return "max";
            }

            @Override
            public String getIsMaxMouseToHuman() {
                return "max";
            }

            @Override
            public Long getMouseOrthologsAboveThreshold() {
                return 1L;
            }

            @Override
            public String getMouseCategoryForThreshold() {
                return "one-to-one";
            }

            @Override
            public Long getMouseSupportCountThreshold() {
                return 5L;
            }

            @Override
            public String getMgiGeneAccId() {
                return "MGI:1917115";
            }

            @Override
            public String getMouseGeneSymbol() {
                return "A1cf";
            }
        });
        return orthologProjections;
    }

}