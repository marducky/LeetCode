package algorithm.LintCode;

/**
 * @project: algorithm.LintCode
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 14:44
 **/
public class _330FindSingle {
    public int findSingle(int[] nums) {
        if (nums.length < 2)
            return nums[0];
        int result = 0;
        for (int n : nums) {
            result = result ^ n;
        }
        return result;
    }
}
