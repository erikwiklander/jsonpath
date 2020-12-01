package io.wiklandia.jsonpath;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JsonPrettyfier {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public String prettify(String input) {
        JsonNode jsonNode = objectMapper.readValue(input, JsonNode.class);
        return jsonNode.toPrettyString();
    }
}
