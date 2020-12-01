package io.wiklandia.jsonpath;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@AllArgsConstructor
public class JsonPathController {

    private final JsonPrettyfier prettyfier;
    private final JsonPathEvaluator jsonPathEvaluator;

    @RequestMapping(path = "/")
    public String jsonPath(Model model, @ModelAttribute UserInput userInput) {
        try {
            userInput.setInputJson(prettyfier.prettify(userInput.getInputJson()));
            userInput.setOutputJson(prettyfier.prettify(jsonPathEvaluator.evaluate(userInput.getInputJson(), userInput.getJsonPath())));
        } catch (Exception e) {
            log.error("e", e);
        }
        return "jsonpath";
    }

}
