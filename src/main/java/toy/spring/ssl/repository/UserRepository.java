package toy.spring.ssl.repository;

import org.springframework.stereotype.Repository;
import toy.spring.ssl.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Repository
public class UserRepository {

    private Map<String, User> users = new HashMap<>();
    private Random random = new Random();

    public User save(User user) {
        user.setId(random.nextInt());
        users.put(user.getEmail(), user);

        return user;
    }

    public User findByEmail(String email) {
        return users.get(email);
    }
}
