/**
 * Given input matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 rotate the input matrix in-place such that it becomes:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 */
package algorithm;

import java.util.Arrays;

public class RotateImageTwo {
    public void rotate(int[][] matrix) {

        int mhLen=matrix.length;//多少行 ==m
        int nsLen=matrix[0].length;//多少竖行 ==n
//        int[][] resMatrix=new int[mhLen][mhLen];
        int[][] resMatrix=matrix;
        for (int i=0;i<mhLen;i++){
            for (int j=0;j<mhLen;j++){
                matrix[i][j]=resMatrix[mhLen-j-1][i];
            }
        }
//        return resMatrix;
    }
    public static void main(String[] args){
//        int[][] giveMatrix={{1,2,3},{4,5,6},{7,8,9}};
        int[][] giveMatrix={{1,2,3,3},{4,5,6,4},{7,8,9,12},{11,12,13,14}};
        for (int[] temMaArray:giveMatrix){
            System.out.println(Arrays.toString(temMaArray));
        }
        RotateImageTwo rotateImageTwo=new RotateImageTwo();
        rotateImageTwo.rotate(giveMatrix);
        for (int[] temReMaArray:giveMatrix){
            System.out.println(Arrays.toString(temReMaArray));
        }

    }
}
