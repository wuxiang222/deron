import com.wux.util.MD5Util;
import org.junit.Test;


public class MD5UtilTest {

    @Test
    public void test0(){
        String md5 = MD5Util.getMD5("456", "123");
        System.out.println(md5);
    }
}
