package pl.infoshare.security.me;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.infoshare.security.domain.OrderUser;

@RestController
public class MeController {

    @GetMapping("/me")
    public MeDetails getMeDetails(@AuthenticationPrincipal OrderUser orderUser) {
        return new MeDetails(
                orderUser.getEmail(),
                orderUser.getAge(),
                orderUser.getRole()
        );
    }
}
