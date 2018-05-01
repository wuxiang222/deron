package testcollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class TestArrayList {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("study");
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
