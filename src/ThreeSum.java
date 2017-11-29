//import java.util.HashMap;
//
//public class ThreeSum {
//    public static int[] threeSun(int[] numbers,int target){
//        if (numbers==null||numbers.length<3)
//            return null;
//        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
//
//    }
//}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ThreeSum {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ThreeSum ts = new ThreeSum();
        int[] num = {-7,2,1,10,9,-10,-5,4,13,-9,-4,6,11,-12,-6,-9,-6,-9,-11,-4,10,10,-3,-1,-4,-7,-12,-15,11,5,14,11,-7,-8,6,9,-2,9,-10,-12,-15,2,10,4,5,11,10,6,-13,6,-13,12,-7,-9,-12,4,-9,13,-4,10,4,-12,6,4,-5,-10,-2,0,14,4,4,6,13,-9,-5,-5,-13,12,-14,11,3,10,8,11,-13,4,-8,-7,2,4,10,13,7,2,2,9,-1,8,-5,-10,-3,6,3,-5,12,6,-3,6,3,-2,2,14,-7,-13,10,-13,-2,-12,-4,8,-1,13,6,-9,0,-14,-15,6,9};
//		int[] num = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
//		int[] num = {0,0,0};
        ArrayList<ArrayList<Integer>> list = ts.threeSum(num);
        long endTime = System.currentTimeMillis();
        System.out.println("Time cost : " + (endTime - startTime));
        System.out.println("list.size = " + list.size());
        for(ArrayList<Integer> al : list){
            System.out.println(al);
        }
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int len = num.length;
        HashSet<int[]> visited = new HashSet<>();
        for (int i = 1; i < len-1; i++) {
            findOtherTwo(num, 0 - num[i], i, visited, result);
        }
        return result;
    }

    private boolean existed(HashSet<int[]> set, int[] tmp) {
        for (int[] a : set) {
            if (a[0] == tmp[0] && a[1] == tmp[1] && a[2] == tmp[2]) {
                return true;
            }
        }
        return false;
    }

    public void findOtherTwo(int[] numbers, int target, int k,
                             HashSet<int[]> set, ArrayList<ArrayList<Integer>> result) {
        int len = numbers.length;
        int low = 0;
        int high = len-1;
        while(low < high && low < k && high > k){
            if(numbers[low] + numbers[high] < target){
                low++;
                continue;
            }
            if(numbers[low] + numbers[high] > target){
                high--;
                continue;
            }
            int[] tmp = new int[] { numbers[low], numbers[k], numbers[high] };
            if (!existed(set, tmp)) {
                ArrayList<Integer> al = new ArrayList<Integer>();
                for (int t : tmp) {
                    al.add(t);
                }
                result.add(al);
                set.add(tmp);
            }
            while(low < k && numbers[low] == tmp[0]){
                low++;
            }
            while(high > k && numbers[high] == tmp[2]){
                high--;
            }
        }
    }
}
