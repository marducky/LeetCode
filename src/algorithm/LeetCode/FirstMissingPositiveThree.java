/**
 * Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.
 */
package algorithm.LeetCode;

public class FirstMissingPositiveThree {
    public int firstMissingPositive(int[] A) {
        if(A==null || A.length==0)
            return 1;
        for (int i=0;i<A.length;i++){
            if (A[i]!=i&&A[i]<A.length){
                int temp=A[A[i]];
                A[A[i]]=A[i];
                A[i]=temp;
            }
        }
        for (int i=0;i<A.length;i++){
            if (A[i]!=i+1)
                return i;
        }
        return A.length+1;


    }
    public static void main(String[] args){
        FirstMissingPositiveThree firstMissingPositive=new FirstMissingPositiveThree();
        int[] ints={1,2,3,4,6};
        System.out.println(firstMissingPositive.firstMissingPositive(ints));
    }

}
