package algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int retReslut=0;
        ArrayList arrayListForStorageResult=new ArrayList();
        ArrayList arrayListForStorageArray=new ArrayList();
        for (int i=0;i<nums.length-2;i++)
            for (int j=i+1;j<nums.length-1;j++)
                for (int l=j+1;l<nums.length;l++) {
                    arrayListForStorageResult.addAll(Arrays.asList(i, j, l, nums[i] + nums[j] + nums[l], Math.abs((nums[i] + nums[j] + nums[l]) - target)));
                    System.out.println(arrayListForStorageResult);
                    arrayListForStorageArray.addAll(arrayListForStorageResult);
                    arrayListForStorageResult.clear();
                }
        System.out.println(arrayListForStorageArray);

        return retReslut;
    }
    public static void main(String[] args){
        int[] numsGive={1,2,3,4,5};
        int targetGive=6;
        threeSumClosest(numsGive,targetGive);
    }
}
