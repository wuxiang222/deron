import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Created by wuxiang
 * on 2018/4/19.
 */
public class ShiroTest {
    public static void main(String[] args) {
        // 第一步 创建SecurityManager
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory();
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // 第二部 创建Subject
        Subject subject = SecurityUtils.getSubject();

        // 第三步 创建Token令牌
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");

        // 第四步 subject携带token信息去找SecurityManager认证
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        System.out.println(subject.isAuthenticated());


        if(subject.hasRole("admin")){
            System.out.println("zhangsan has admin role");
        }else {
            System.out.println("zhangsan has not admin role");
        }
        subject.logout();
        System.out.println(subject.isAuthenticated());

    }


    @Test
    public void testMD5Hash(){
        Md5Hash md5Hash = new Md5Hash("123456");
        System.out.println(md5Hash);
        // e10adc3949ba59abbe56e057f20f883e
        Md5Hash aaa = new Md5Hash("123456", "aaa");
        System.out.println(aaa);
        // 88316675d7882e3fdbe066000273842c
        Md5Hash aaa123456 = new Md5Hash("aaa123456");
        System.out.println(aaa123456);
    }
}
