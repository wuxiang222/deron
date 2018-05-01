package testio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class Test04Inputstream {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("FileOutputStreamCreateFile.txt");
        if (2 > 3) {
            System.out.println(fileInputStream.read());
            System.out.println(fileInputStream.read());
            System.out.println(fileInputStream.read());
            System.out.println(fileInputStream.read());
            fileInputStream.close();
        } else if (2 > 5) {
            int ch = 0;
            while ((ch = fileInputStream.read()) != -1) {
                System.out.print((char) ch);
            }
            fileInputStream.close();
        } else {
            byte[] bs = new byte[16];
            int len = 0;
            while ((len = fileInputStream.read(bs)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print((char) bs[i]);
                }
                System.out.println();
            }
            fileInputStream.close();
        }
    }
}

