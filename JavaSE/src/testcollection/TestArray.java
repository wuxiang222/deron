package testcollection;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class TestArray {
    public static void main(String[] args) {
        String[] names = new String[3];
        names[0] = "zhang3";
        names[1] = "li4";
        names[2] = "wang5";

        // 插入zhao6之前需要扩容
        String[] newNames = new String[names.length*2];
        for (int i = 0; i <names.length ; i++) {
            newNames[i] = names[i];
        }
        names = newNames;
        // 插入（使用for循环，而直接赋值）
        names[3] = names[2];
        names[2] = names[1];
        names[1] = "zhao6";

        for (String name: names
             ) {
            System.out.println(name);
        }
    }
}
