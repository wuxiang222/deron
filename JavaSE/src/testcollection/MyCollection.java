package testcollection;

import java.util.Iterator;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public interface MyCollection {
    boolean add(Object o);
    boolean contains(Object o);
    boolean isEmpty();
    Iterator iterator();
    boolean remove(Object o);
    void clear();
    int size();
}
