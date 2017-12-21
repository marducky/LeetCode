/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
package algorithm;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0)
            return false;
        int end=matrix[0][0]-target;
        for (int[] tempInts:matrix){
            if (!isSortedMatrix(tempInts)){
                return false;
            }
            if (tempInts[0]!=end+target){
                return false;
            }
            end=tempInts[tempInts.length-1];
        }
        return true;
    }
    public boolean isSortedMatrix(int[] perMatrix){
        for (int i=0;i<perMatrix.length-1;i++){
            if (perMatrix[i]>perMatrix[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        SearchA2DMatrix searchA2DMatrix=new SearchA2DMatrix();
        int[][] ints={{1,2,3},{5,8,7},{9,10,11},{13,14,15}};
        System.out.print(searchA2DMatrix.searchMatrix(ints,2));
    }
}
