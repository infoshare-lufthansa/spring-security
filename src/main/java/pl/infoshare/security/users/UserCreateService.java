package pl.infoshare.security.users;

import org.springframework.stereotype.Component;
import pl.infoshare.security.domain.OrderUser;

@Component
public class UserCreateService {

    public void createUser(OrderUser orderUser) {
        System.out.println("Creating... " + orderUser);
    }

}
