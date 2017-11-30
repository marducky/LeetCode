package algorithm;

import java.util.Arrays;

/*
* Given an array S of n integers,
* are there elements a, b, c in S such that a + b + c = 0?
* Find all unique triplets in the array which gives the sum of zero.
* For example, given array S = [-1, 0, 1, 2, -1, -4],
* A solution set is:
* [
*   [-1, 0, 1],
*   [-1, -1, 2]
* ]
* */
public class ThreeSumSum {
    public static int[][] findArray(int[] intsArry){
        int len=intsArry.length,pFlag=0;
        int[][] intsRestl=new int[len][3];
        for (int i=0;i<intsArry.length-2;i++){
            for (int j=i+1;j<intsArry.length-1;j++){
                for (int l=j+1;l<intsArry.length;l++){
                    if (intsArry[i]+intsArry[j]+intsArry[l]==0) {
                        intsRestl[pFlag][0] = intsArry[i];
                        intsRestl[pFlag][1] = intsArry[j];
                        intsRestl[pFlag][2] = intsArry[l];
                        pFlag++;
                    }
                }
            }
        }
        return intsRestl;
    }
    public static void main(String[] args){
        int[] giveIntArray={1,2,3,4,-1,-2,-0};
        int[] giveIntArrayTwo={-1, 0, 1, 2, -1, -4};
        int relAyyLen=findArray(giveIntArrayTwo).length;
//        System.out.println(relAyyLen);
        for (int k=0;k<relAyyLen;k++){
            System.out.println(Arrays.toString(findArray(giveIntArrayTwo)[k]));
        }
    }

}
