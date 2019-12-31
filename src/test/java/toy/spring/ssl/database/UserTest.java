package toy.spring.ssl.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import toy.spring.ssl.domain.User;
import toy.spring.ssl.repository.UserRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    private static final Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void crud() {
        User user = new User("root", passwordEncoder.encode("password"), "root@root.com", "ROLE_ROOT");

        logger.info("User : {}", user);

        int row = repository.save(user);
        assertThat(row, is(1));

        User dbUser = repository.findById("root");
        assertThat(dbUser, is(user));
    }
}