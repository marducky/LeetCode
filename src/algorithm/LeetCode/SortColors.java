/**
 *Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.
 */
package algorithm.LeetCode;

import java.util.Arrays;

public class SortColors {
    public void swap(int A[], int i, int j){
        int tmp = A[i];
        A[i]=A[j];
        A[j]=tmp;
    }

    public void sortColors(int A[]) {
        if(A == null || A.length==0)
            return;

        int notred=0;
        int notblue=A.length-1;

        while (notred<A.length&&A[notred]==0)
            notred++;

        while (notblue>=0&&A[notblue]==2)
            notblue--;

        int i=notred;
        while (i<=notblue){
            if (A[i]==0) {
                swap(A,i,notred);
                notred++;
                i++;
            }else if (A[i]==2) {
                swap(A,i,notblue);
                notblue--;
            }else
                i++;
        }
    }
    public static void main(String[] args){
        SortColors sortColors=new SortColors();
        int[] ints={0,1,2,1,0,2,1,2,2,2,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,2,1,0,1,0,1,0,1,0,2,0,2,0};
        System.out.println(Arrays.toString(ints));
        sortColors.sortColors(ints);
        System.out.print(Arrays.toString(ints));
    }
}
