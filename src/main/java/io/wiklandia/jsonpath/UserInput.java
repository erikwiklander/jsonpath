package io.wiklandia.jsonpath;

import lombok.Data;

@Data
public class UserInput {
    private String jsonPath;
    private String inputJson;
    private String outputJson;
    private String errorMessage;
}
