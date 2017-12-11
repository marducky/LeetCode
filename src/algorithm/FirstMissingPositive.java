/**
 * Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.
 */
package algorithm;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set=new TreeSet<Integer>();
        for (int i=0;i<nums.length;i++){
            if (nums[i]>0){
                set.add(nums[i]);
            }
        }
        System.out.println(set);
        Iterator<Integer> iterator=set.iterator();
        while (iterator.hasNext()){
            int tempInt=iterator.next();
            if ((tempInt+1)!=(iterator.next()))
                return tempInt+1;
        }
        return set.iterator().next();
    }
    public static void main(String[] args){
        FirstMissingPositive firstMissingPositive=new FirstMissingPositive();
        int[] ints={1,2,3,4,6};
        System.out.println(firstMissingPositive.firstMissingPositive(ints));
    }

}
