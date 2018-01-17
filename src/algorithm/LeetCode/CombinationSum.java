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
import java.util.List;
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listList=new ArrayList();
        int gLen=candidates.length;
        candidates=sortGiveInt(candidates);
        List<Integer> list=new ArrayList<Integer>();
        if (target<candidates[0]||target>candidates[candidates.length-1])
            return null;
//        int tempI=candidates[candidates.length-1];
        for (int i=candidates.length-1;i>=0;i--) {
            List<Integer> tempList = new ArrayList<Integer>();
            int tempI=i,tempTarget=target;
            while (tempTarget >= 0) {
                if ((candidates[tempI] - tempTarget)==0) {
                    tempTarget=candidates[tempI]-tempTarget;
                    tempList.add(candidates[tempI]);
                    break;
                }
                else {
                    tempTarget = candidates[tempI] - tempTarget;
                    tempList.add(candidates[tempI]);
                    tempI--;
                }

            }
            if (tempTarget==0)
                listList.add(tempList);
        }
        return listList;
    }
    public int[] sortGiveInt(int[] giveInt){
        for (int i=0;i<giveInt.length;i++){
            for (int j=i+1;j<giveInt.length;j++){
                if (giveInt[i]>giveInt[j]){
                    int temp=giveInt[i];
                    giveInt[i]=giveInt[j];
                    giveInt[j]=temp;
                }
            }
        }
        return giveInt;
    }
    public static void main(String[] args){
        CombinationSum combinationSum=new CombinationSum();
        int[] ints={1,2,4,5};

        System.out.print(combinationSum.combinationSum(ints,5));
    }

}
