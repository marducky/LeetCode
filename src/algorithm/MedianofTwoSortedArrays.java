package algorithm;

import java.util.HashSet;

public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        HashSet<Integer> set=new HashSet<Integer>();
        for (int i=0;i<nums2.length;i++)
            set.add(nums2[i]);
        for (int j=0;j<nums1.length;j++){
            if (!set.contains(nums1[j]))
                set.add(nums1[j]);
        }
        return set.size();
    }
    public static void main(String[] args){
        int[] num1={1,2,3,4};
        int[] num2={2,3,4,5,6};
        System.out.println(findMedianSortedArrays(num1,num2));
    }
}
