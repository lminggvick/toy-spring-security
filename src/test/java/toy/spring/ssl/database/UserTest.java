package toy.spring.ssl.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import toy.spring.ssl.domain.model.User;
import toy.spring.ssl.domain.type.UserRoleType;
import toy.spring.ssl.repository.UserRepository;
import toy.spring.ssl.service.UserService;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    private static final Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    private UserService service;

    @Test
    public void crud() {
        User user = new User("test", "123", "test@test.com", UserRoleType.USER.getName());

        logger.info("User : {}", user);

        int row = this.service.save(user);
        assertThat(row, is(1));

        User dbUser = this.service.findById("test");
        assertThat(dbUser, is(user));
    }
}
