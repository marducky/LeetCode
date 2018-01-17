/**
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
package algorithm.LeetCode;

public class MaximumSubarrayTwo {
    public int maxSubArray(int[] A) {
        return divide(A, 0, A.length-1);
    }

    public int divide(int A[], int low, int high){
        if(low == high)
            return A[low];
        if(low == high-1)
            return Math.max(A[low]+A[high], Math.max(A[low], A[high]));

        int mid = (low+high)/2;
        int lmax = divide(A, low, mid-1);
        int rmax = divide(A, mid+1, high);

        int mmax = A[mid];
        int tmp = mmax;
        for(int i = mid-1; i >=low; i--){
            tmp += A[i];
            if(tmp > mmax)
                mmax = tmp;
        }
        tmp = mmax;
        for(int i = mid+1; i <= high; i++){
            tmp += A[i];
            if(tmp > mmax)
                mmax = tmp;
        }
        return Math.max(mmax, Math.max(lmax, rmax));

    }
    public static void main(String[] args){
        MaximumSubarrayTwo maximumSubarray=new MaximumSubarrayTwo();
        int[] nums1={1,2,3,4};
        int[] nums={-2,1,-3,4,-1,2,1,5,4};
        System.out.print(maximumSubarray.maxSubArray(nums));
    }
}
