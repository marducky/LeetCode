/**
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
package algorithm.LeetCode;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumTwo {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        if(candidates == null || candidates.length==0)
            return res;

        Arrays.sort(candidates);
        helper(candidates,target, 0, item ,res);
        return res;
    }

    private void helper(int[] candidates, int target, int start, ArrayList<Integer> item,
                        ArrayList<ArrayList<Integer>> res){
        if(target<0)
            return;
        if(target==0){
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for(int i=start;i<candidates.length;i++){
            if(i>0 && candidates[i] == candidates[i-1])//deal with dupicate
                continue;
            item.add(candidates[i]);
            int newtarget = target - candidates[i];
            helper(candidates,newtarget,i,item,res);//之所以不传i+1的原因是：
            //The same repeated number may be
            //chosen from C unlimited number of times.
            item.remove(item.size()-1);
        }

    }
    public static void main(String[] args){
        CombinationSumTwo combinationSum=new CombinationSumTwo();
        int[] ints={1,2,4,5};

        System.out.print(combinationSum.combinationSum(ints,5));
    }

}
