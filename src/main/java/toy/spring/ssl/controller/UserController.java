package toy.spring.ssl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.spring.ssl.domain.User;
import toy.spring.ssl.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/create")
    public User create() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("password");

        service.save(user);

        return user;
    }
}
