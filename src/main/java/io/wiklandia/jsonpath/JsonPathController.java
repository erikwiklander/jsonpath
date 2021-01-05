package io.wiklandia.jsonpath;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

@Slf4j
@Controller
@AllArgsConstructor
public class JsonPathController {

    private final JsonPrettyfier prettyfier;
    private final JsonPathEvaluator jsonPathEvaluator;

    @RequestMapping(path = "/")
    public String jsonPath(@ModelAttribute UserInput userInput) {
        String template = "jsonpath";
        String inputJson = userInput.getInputJson();
        String jsonPath = userInput.getJsonPath();
        if (StringUtils.isEmpty(inputJson) || StringUtils.isEmpty(jsonPath)) {
            return template;
        }
        try {
            userInput.setInputJson(prettyfier.prettify(inputJson));
            userInput.setOutputJson(prettyfier.prettify(jsonPathEvaluator.evaluate(inputJson, jsonPath)));
        } catch (Exception e) {
            userInput.setOutputJson("");
            userInput.setErrorMessage(e.getMessage());
            log.error("Error", e);
        }
        return template;
    }

}
