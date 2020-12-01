package io.wiklandia.jsonpath;

import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.springframework.stereotype.Service;

@Service
public class JsonPathEvaluator {

    public String evaluate(String jsonString, String jsonPath) {
        DocumentContext documentContext = JsonPath.parse(jsonString);
        JsonNode jsonNode = documentContext.read(jsonPath, JsonNode.class);
        return jsonNode.toPrettyString();
    }
}
