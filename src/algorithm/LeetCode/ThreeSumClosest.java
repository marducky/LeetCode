package algorithm.LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ThreeSumClosest {
    public static String returnName(int num){
        return "arrayListForStorageResult"+Integer.toString(num);
    }
    public static int changer(int a,int b){
        return a<b?a:b;
    }
    public static int threeSumClosest(int[] nums, int target) {
        int retReslut=0;
//        ArrayList arrayListForStorageResult=new ArrayList();
        ArrayList<ArrayList> arrayListForStorageArray=new ArrayList<ArrayList>();
        for (int i=0;i<nums.length-2;i++)
            for (int j=i+1;j<nums.length-1;j++)
                for (int l=j+1;l<nums.length;l++) {
                    String contactName=returnName(i);
                    ArrayList arrayListForStorageResult=new ArrayList();

                    arrayListForStorageResult.addAll(Arrays.asList(i, j, l, nums[i] + nums[j] + nums[l], Math.abs((nums[i] + nums[j] + nums[l]) - target)));
//                    System.out.println(arrayListForStorageResult);
                    arrayListForStorageArray.add(arrayListForStorageResult);
//                    arrayListForStorageResult.clear();
                }
//        Iterator iterator=arrayListForStorageArray.iterator();
//        while (iterator.hasNext()){
////            for (int i=)
//            System.out.println(iterator.next().toString().charAt(iterator.next().toString().length()-2));
//        }
//        System.out.println(arrayListForStorageArray.get(0).getClass().getName());
//        System.out.println(arrayListForStorageArray.get(0).get(4).getClass().getName());
//        System.out.println(arrayListForStorageArray.get(0).get(4).toString());
        int flag=Integer.valueOf(arrayListForStorageArray.get(0).get(4).toString());
        int iFlag=0;
        for (int i=0;i<arrayListForStorageArray.size();i++){
            if (Integer.valueOf(arrayListForStorageArray.get(i).get(4).toString())<flag)
                iFlag=i;
                flag=changer(flag,Integer.valueOf(arrayListForStorageArray.get(i).get(4).toString()));
        }
        retReslut=Integer.valueOf(arrayListForStorageArray.get(iFlag).get(3).toString());


        return retReslut;
    }
    public static void main(String[] args){
        int[] numsGive={-1,2,3,4,6};
        int[] numsGiveTwo={87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4};
        int targetGive=14;
        System.out.println(threeSumClosest(numsGiveTwo,targetGive));
    }
}
