import com.wux.dao.UserDao;
import com.wux.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wuxiang
 * on 2018/4/18.
 */

public class MybatisTest {
    @Test
    public void testUser() throws IOException {
        // 1 读取配置文件 已废弃mybatis-config.xml
        InputStream in = Resources.getResourceAsStream("已废弃mybatis-config.xml");
        // 2 创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3 创建SqlSession
        SqlSession sqlSession = factory.openSession();
        // 4 通过sqlSession拿到dao接口的实现类
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 5 调用实现类方法
        User user = userDao.findUser("zhangsan","123456");
        System.out.println(user);
    }
}
