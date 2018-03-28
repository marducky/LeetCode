package algorithm.LintCode;

import java.util.Arrays;

/**
 * @project: algorithm.LintCode
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 14:37
 **/
public class M633_FindDuplicate {
    public int findDuplicate(int[] nums) {
        // write your code here
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                result = nums[i];
            }

        }
        return result;
    }

    public static void main(String[] args) {
        M633_FindDuplicate findDuplicate = new M633_FindDuplicate();
        int n[] = {3, 2, 1, 4, 7, 7};
        System.out.println(findDuplicate.findDuplicate(n));

    }
}
