package pl.infoshare.security.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class OrderUser {
    private Integer id;
    private String email;
    private String password;
    private Integer age;
}
