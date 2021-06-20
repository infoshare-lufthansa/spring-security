package pl.infoshare.security.users;

import org.springframework.stereotype.Component;
import pl.infoshare.security.domain.OrderUser;

import java.util.Collections;
import java.util.List;

@Component
public class UserFindService {

    public List<OrderUser> findAllUsers() {
        return Collections.emptyList();
    }
}
