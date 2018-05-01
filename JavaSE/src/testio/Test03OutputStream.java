package testio;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class Test03OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("FileOutputStreamCreateFile.txt");
        if( 2 > 3){
            fileOutputStream.write((int)'a');
            fileOutputStream.write((int)'b');
            fileOutputStream.write((int)'c');
            fileOutputStream.close();
        } else {
            String hello = "Hello World!";
            byte[] bytes = hello.getBytes();
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        }
    }
}
