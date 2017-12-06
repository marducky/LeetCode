/*11421-->14112*/
package algorithm;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int nLen=nums.length;
        boolean bFlag=false;
        for (int i=nLen-1;i>0;i--){
            if (nums[i]>nums[i-1]){
                nums=sortInt(i,nums);
//                System.out.println("the location is : "+i);
                bFlag=true;
                break;
            }
        }
        if (!bFlag){
            nums=sortInt(-1,nums);
        }
        System.out.print(Arrays.toString(nums));
    }
    public static int[] sortInt(int location,int[] num){
//        int[] newResult=new int[num.length];
        if (location!=-1){
            int temp=num[location-1];
            num[location-1]=num[location];
            num[location]=temp;
        }
        for (int i=location+1;i<num.length-1;i++){
            for (int j=i+1;j<num.length;j++){
                if (num[i]>num[j]){
                    int inTemp=num[i];
                    num[i]=num[j];
                    num[j]=inTemp;
                }
            }
        }
        return num;
    }
    public static void main(String[] args){
//        int[] giveNum={1,1,4,2,1,1};
//        int[] giveNum1={1,1,4,2,1};
//        int[] giveNum2={1,2,3};
//        int[] giveNum3={3,2,1};
        int[] giveNum4={1,3,2};
//        System.out.print(Arrays.toString(giveNum)+"->");
//        nextPermutation(giveNum);
//        System.out.println();
//        System.out.print(Arrays.toString(giveNum1)+"->");
//        nextPermutation(giveNum1);
//        System.out.println();
//        System.out.print(Arrays.toString(giveNum2)+"->");
//        nextPermutation(giveNum2);
//        System.out.println();
//        System.out.print(Arrays.toString(giveNum3)+"->");
//        nextPermutation(giveNum3);
        System.out.print(Arrays.toString(giveNum4)+"->");
        nextPermutation(giveNum4);
    }

}
