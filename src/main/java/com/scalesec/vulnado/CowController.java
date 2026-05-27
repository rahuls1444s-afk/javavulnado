package com.scalesec.vulnado;

import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.*;
inport org.springframework.web.util.HtmlUtils;
import java.io.Serializable;

@RestController
@EnableAutoConfiguration
public class CowController {
    @RequestMapping(value = "/cowsay")
    String cowsay(@RequestParam(defaultValue = "I love Linux!") String input) {
        String vInput = HtmlUtils.htmlEscape(input);
        return Cowsay.run(vInput);
    }
}
