package testio;

import jdk.nashorn.internal.runtime.regexp.RegExp;

import java.io.File;
import java.io.IOException;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class Test02ListFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("../");
        System.out.println(file.getCanonicalPath());
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            printFile(files[i]);
        }
    }

    // 打印File代表目录下所有 java 文件
    public static void printFile(File f){
        File[] files = f.listFiles();
        for (File file : files
             ) {
            boolean directory = file.isDirectory();
            if(directory){
                printFile(file);
            }
            else if(file.getName().endsWith(".java")){
                System.out.println(file.getName());
            }
        }
    }
}
