package org.orthologyapi.conf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(RestDocumentationExtension.class)
@Tag(ControllerTestTemplate.TAG)
public class ControllerTestTemplate extends IntegrationTestTemplate {

    public static final String TAG = "ControllerTest";
    private MockMvc mvc;


    @Autowired
    private WebApplicationContext applicationContext;

    @BeforeEach
    public void setup(RestDocumentationContextProvider restDocumentation) throws Exception
    {
        MockitoAnnotations.initMocks(this);
        mvc =
            MockMvcBuilders.webAppContextSetup(applicationContext)
                .apply(MockMvcRestDocumentation.documentationConfiguration(restDocumentation))
                .build();
    }

    protected MockMvc mvc() {
        return mvc;
    }
}
