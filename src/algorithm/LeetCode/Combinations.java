/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
package algorithm.LeetCode;

import java.util.ArrayList;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> resultListList = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || n < k)
            return resultListList;
        ArrayList<Integer> item = new ArrayList<Integer>();
        dfs(n, k, 1, item, resultListList);
        return resultListList;

    }

    private void dfs(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }
    public static void main(String [] args){
        Combinations combinations=new Combinations();
        System.out.println(combinations.combine(6,1));
    }

}

