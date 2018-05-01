package testcollection;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class MyList {
    // 容器结构
    private Object[] data;
    private int index;
    public MyList(){
        data = new Object[5];
        index= 0;
    }

    // 末尾添加
    public void add(Object value){}

    // 插入指定位置pos,且自动扩容
    public void add(int pos, Object value){}

    // 删除pos位置的元素
     public void delete(int pos){}

     // 获得pos位置的元素
    public Object get(int pos){return null;}

    // 获得容器中元素的个数
    public int size(){return 0;}

    // 判断容器中包含obj对象
    public boolean contains(Object obj){return false;}
}
