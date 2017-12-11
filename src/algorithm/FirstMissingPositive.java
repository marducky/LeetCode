package algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set=new TreeSet<Integer>();
        int resInt=0;

//        set.add(2);
//        set.add(3);
//        set.add(1);
//        System.out.print(set);
        set.iterator().next();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for (int i=0;i<nums.length;i++) {
        }
        return resInt;
    }
    public static void main(String[] args){
        int[] num={1,2,3,4,6,7};
        System.out.print(firstMissingPositive(num));
    }
}
