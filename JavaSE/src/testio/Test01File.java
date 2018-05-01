package testio;

import java.io.File;
import java.io.IOException;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class Test01File {
    public static void main(String[] args) throws IOException {
        File file = new File("abc/test.txt");
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getName());

        file = new File("../../");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());


        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }
}
