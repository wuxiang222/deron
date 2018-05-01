package testcollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class TestMap {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("2006", "Italy");
        map.put("2002", "Brazil");
        map.put("1998", "France");
        map.put("1994", "Brazil");

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();
            System.out.println( key + " -- " + map.get(key));
        }

        /*Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + " ---- "+ entry.getValue());
        }*/
    }
}
