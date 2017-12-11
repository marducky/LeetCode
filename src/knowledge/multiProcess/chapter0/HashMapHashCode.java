package knowledge.multiProcess.chapter0;

import java.util.HashMap;
import java.util.Map;

public class HashMapHashCode {
    public static void main(String[] args){
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        map.put(3,3);
        map.put(3,3);
        map.put(3,4);
        map.put(4,4);
//        map.hashCode();
        System.out.println(map.get(3));
    }
}
