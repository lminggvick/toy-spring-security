package toy.spring.ssl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import toy.spring.ssl.domain.model.User;
import toy.spring.ssl.repository.UserRepository;
import toy.spring.ssl.security.CustomUserDetails;

@Service
public class UserService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = this.repository.findById(userId);
        logger.warn("find db user : {}", user);

        return new CustomUserDetails(user);
    }

    public int save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        return this.repository.save(user);
    }

    public User findById(String userId) {
        return this.repository.findById(userId);
    }
}
