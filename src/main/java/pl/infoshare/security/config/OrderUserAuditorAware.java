package pl.infoshare.security.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.infoshare.security.domain.OrderUser;

import java.util.Optional;

@Component
public class OrderUserAuditorAware implements AuditorAware<OrderUser> {

    @Override
    public Optional<OrderUser> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .filter(p -> p instanceof OrderUser)
                .map(p -> (OrderUser) p);
    }
}
