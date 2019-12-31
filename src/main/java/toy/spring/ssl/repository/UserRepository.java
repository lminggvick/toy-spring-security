package toy.spring.ssl.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import toy.spring.ssl.domain.User;

@Repository
public class UserRepository {

    @Autowired
    private SqlSession sqlSession;

    public int save(User user) {
        return sqlSession.insert("createUser", user);
    }

    public User findById(String userId) {
        return sqlSession.selectOne("selectByUserId", userId);
    }
}
