import com.wux.dao.MenusDao;
import com.wux.dao.UserDao;
import com.wux.entity.Menus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wuxiang
 * on 2018/5/5.
 */

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DaoTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MenusDao menusDao;

    @Test
    public void test0(){
        Menus menus = new Menus(2, "ffff", new Menus(), 2222, 1111, "qweqwe");
        menusDao.modifyMenus(menus);
    }
}
