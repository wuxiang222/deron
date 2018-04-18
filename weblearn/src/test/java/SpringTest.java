import com.wux.dao.UserDao;
import com.wux.entity.User;
import com.wux.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/4/18.
 */
//测试类开始实行时，启动Spring工厂
@ContextConfiguration(value="classpath:applicationContext.xml")
//已SpringJUnit4方式运行测试类
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @Test
    public void testFindUser(){
        User user = userDao.findUser("zhangsan", "123456");
        System.out.println(user);
    }
    @Test
    public void testFineAll(){
        List<User> list = userDao.findAll();
        for (User user : list){
            System.out.println(user);
        }
    }
    @Test
    public void testAddUser(){
        userDao.addUser(new User(null, "haolai", "123456", "第二个用户"));
    }
    @Test
    public void testRemoveUser(){
        userDao.removeUser(8);
    }
    @Test
    public void testModifyUser(){
//        userDao.modifyUser(new User(3, "wangwu", "123456", "第二个用户"));
        userService.modifyUser(new User(3, "wangwu33", "123456", "第四个用户"));
    }
}
