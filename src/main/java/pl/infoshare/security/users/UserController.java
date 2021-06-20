package pl.infoshare.security.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.infoshare.security.domain.OrderUser;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserFindService userFindService;
    private final UserCreateService userCreateService;

    @GetMapping("/users")
    public List<OrderUser> getUsers() {
        return userFindService.findAllUsers();
    }

    @PostMapping("/users")
    public void createUser(@RequestBody OrderUser user) {
        userCreateService.createUser(user);
    }
}
