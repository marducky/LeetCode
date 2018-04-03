package algorithm.LintCode;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/03 15:38
 **/

import knowledge.baseKnowledge.struchData.arrayList;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Example
 * Given capacity=3
 * <p>
 * set(2,2)
 * set(1,1)
 * get(2)
 * >> 2
 * get(1)
 * >> 1
 * get(2)
 * >> 2
 * set(3,3)
 * set(4,4)
 * get(3)
 * >> -1
 * get(2)
 * >> 2
 * get(1)
 * >> 1
 * get(4)
 * >> 4
 */
public class H24_LFUCache {

    private Map<Integer, Integer> storeMap = new HashMap<>();
    private int capacity;

    public H24_LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public void set(int key, int value) {
        if (storeMap.containsKey(key) && storeMap.get(key) != -1) {

            storeMap.replace(key, value);

        } else if (storeMap.containsKey(key) && storeMap.get(key) == -1) {

            storeMap.remove(key, -1);
            System.out.println(storeMap.size());


        } else if (storeMap.size() < this.capacity) {

            storeMap.put(key, value);

        } else {

            ArrayList<Integer> arrayList = new ArrayList<>();
            storeMap.forEach((k, v) -> {
                arrayList.add(v);
            });
            Collections.sort(arrayList);
            if (arrayList.get(capacity - 1) < value) {
                storeMap.put(key, -1);
            } else {
                ArrayList<Integer> arrayListTwo = new ArrayList<>();
                storeMap.forEach((k, v) -> {
                    if (v == arrayList.get(capacity - 1)) {
                        arrayListTwo.add(k);
                    }
                });
                arrayListTwo.forEach(integer -> {
                    storeMap.replace(integer, -1);
                });
                storeMap.put(key, value);
            }
        }
    }

    public int get(int key) {
        return storeMap.get(key);
    }

    public static void main(String[] args) {
        H24_LFUCache h24_lfuCache = new H24_LFUCache(3);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        storeMap.forEach((k, v) -> {
            sb.append("[" + k + ", " + v + "]\n");
        });
        return sb.toString();
    }
}
