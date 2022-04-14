package pl.infoshare.security.me;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.infoshare.security.config.AccountInfo;
import pl.infoshare.security.config.AccountToken;
import pl.infoshare.security.domain.OrderUser;

@RestController
public class MeController {

    @GetMapping("/me")
    public MeDetails getMeDetails(@AuthenticationPrincipal AccountInfo accountInfo) {
        return new MeDetails(accountInfo.getEmail(), 1, accountInfo.getRole());
    }
}
