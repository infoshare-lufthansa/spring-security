package pl.infoshare.security.config;

public class AccountInfo {

    private final String email;
    private final String role;

    public AccountInfo(String email, String role) {
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
