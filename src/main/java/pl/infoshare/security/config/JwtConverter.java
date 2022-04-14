package pl.infoshare.security.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;
import java.util.stream.Collectors;


public class JwtConverter implements Converter<Jwt, AccountToken> {
    private final ObjectMapper objectMapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    @Override
    public AccountToken convert(Jwt jwt) {
        var userName = jwt.getClaimAsString("email");
        var access = getResourceAccess(jwt);
        var roles = access.getPizzaService().getRoles().stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r)).collect(Collectors.toList());

        return new AccountToken(userName, roles);
    }

    private ResourceAccess getResourceAccess(Jwt jwt) {
        try {
            return objectMapper.readValue(jwt.getClaimAsString("resource_access"), ResourceAccess.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

class ResourceAccess {
    private final PizzaService pizzaService;

    @JsonCreator
    public ResourceAccess(@JsonProperty("pizza-service") PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    public PizzaService getPizzaService() {
        return pizzaService;
    }
}

class PizzaService {
    private final List<String> roles;

    @JsonCreator
    public PizzaService(@JsonProperty("roles") List<String> roles) {
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }
}