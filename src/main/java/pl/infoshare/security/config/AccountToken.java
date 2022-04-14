package pl.infoshare.security.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

public class AccountToken extends AbstractAuthenticationToken {

    private String email;

    public AccountToken(String email, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.email = email;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return new AccountInfo(email, getAuthorities().stream().findFirst().map(GrantedAuthority::getAuthority).orElse(""));
    }
}
