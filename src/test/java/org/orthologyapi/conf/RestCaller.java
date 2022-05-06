package org.orthologyapi.conf;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class RestCaller {

    private final MockMvc mvc;
    private static final String HEADER_AUTHORIZATION = "Authorization";

    public RestCaller(MockMvc mvc) {
        this.mvc = mvc;
    }

    public String executeGetAndDocument(String url, ResultHandler documentMethod) throws Exception
    {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders
            .get(url)
            .header(HEADER_AUTHORIZATION, "None"))
            .andExpect(status().isOk())
            .andDo(documentMethod);
        MvcResult obtained = resultActions.andReturn();
        return obtained.getResponse().getContentAsString();
    }

}
