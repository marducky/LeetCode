/**
 * Given the following matrix:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].


 */
package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList=new ArrayList<Integer>();
        int mLen=matrix.length;
        int nLen=matrix[0].length;
        if ((mLen*nLen==0))
            return Arrays.asList(0);
        int mHI=0;
        int nSI=0;
        while ((mLen-2*mHI>=0)&&(nLen-2*nSI>=0)){
            for (int i=nSI;i<nLen-2*nSI-1;i++)
                resList.add(matrix[mHI][i]);
            for (int j=mHI;j<mLen-2*mHI-1;j++)
                resList.add(matrix[j][nLen-2*nSI-1]);
//            resList.remove(matrix[mHI][nLen-2*nSI-1]);
            for (int k=nLen-2*nSI-1;k>nSI;k--)
                resList.add(matrix[mLen-2*mHI-1][k]);
//            resList.remove(matrix[mLen-2*mHI-1][nLen-2*nSI-1]);
            for (int g=mLen-2*mHI-1;g>mHI;g--)
                resList.add(matrix[g][nSI]);
//            resList.remove(matrix[mHI][nSI]);
            mHI++;
            nSI++;
//            for (int tempI:matrix[mHI]){
//                resList.add(tempI);
//            }
//            for (int tempII:matrix[nLen-nSI-1]){
//                resList.add(tempII);
//            }
//            resList.remove(matrix[mHI][nLen-nSI-1]);
//            for (int i=)
//
//
//            for (int i=0;i<mLen;i++){
//                for (int j=0;j<nLen;j++){
//
//                }
//            }
        }

        return resList;
    }
    public static void main(String[] arrgs){
        SpiralMatrix spiralMatrix=new SpiralMatrix();
        int[][] giveNums={{1, 2, 3},{4, 5, 6},{7, 8, 9},{10,11,12},{13,14,15}};
        System.out.print(spiralMatrix.spiralOrder(giveNums));
    }
}
