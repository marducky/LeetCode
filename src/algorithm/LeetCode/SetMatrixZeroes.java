/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
package algorithm.LeetCode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> integerSet=new TreeSet<Integer>();
        Set<Integer> integerSetTwo=new TreeSet<Integer>();
        int hLen=matrix.length;
        int sLen=matrix[0].length;
        for (int i=0;i<hLen;i++){
            for (int j=0;j<sLen;j++){
                if (integerSet.contains(j))
                    continue;
                if (matrix[i][j]==0){
                    integerSet.add(j);
                    integerSetTwo.add(i);
                }
            }
        }
        for (int i=0;i<hLen;i++){
            if (integerSetTwo.contains(i)){
                for (int j=0;j<sLen;j++){
                    matrix[i][j]=0;
                }
                continue;
            }
            for (int j=0;j<sLen;j++){
                if (integerSet.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
    public static void main(String[] args){
        SetMatrixZeroes setMatrixZeroes=new SetMatrixZeroes();
        int[][] ints={{1,2,0,9,8},{3,7,4,0,5},{3,7,6,3,4},{2,4,6,0,6},{2,3,0,4,9}};
        for (int[] tempInt:ints){
            System.out.println(Arrays.toString(tempInt));
        }
        setMatrixZeroes.setZeroes(ints);
        System.out.println("++++++++++++++++++++++++");
        for (int[] tempInt:ints){
            System.out.println(Arrays.toString(tempInt));
        }
    }

}
