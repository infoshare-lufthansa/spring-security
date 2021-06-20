package pl.infoshare.security.welcome;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private String rootText;
    private final String welcomeText;

    public WelcomeController(@Value("${app.root-text}") String rootText,
                             @Value("${app.welcome-text}") String welcomeText) {
        this.rootText = rootText;
        this.welcomeText = welcomeText;
    }

    @GetMapping("/")
    public String getRoot() {
        return rootText;
    }

    @GetMapping("/welcome-text")
    public String getWelcome() {
        return welcomeText;
    }
}
