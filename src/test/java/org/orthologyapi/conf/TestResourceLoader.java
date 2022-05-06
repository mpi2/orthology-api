package org.orthologyapi.conf;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TestResourceLoader {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a z");
        objectMapper.setDateFormat(df);
    }


    public static String loadJsonFromResource(String resourcePath) throws IOException {
        String result = null;
        try (InputStream in = TestResourceLoader.class.getResourceAsStream(resourcePath)) {
            JsonNode jsonNode = objectMapper.readValue(in, JsonNode.class);
            result = objectMapper.writeValueAsString(jsonNode);
        }
        return result;
    }
}
