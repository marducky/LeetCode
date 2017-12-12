package algorithm;

import java.util.ArrayList;

public class PermutationsThree {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> resArrayListArrayList=new ArrayList<ArrayList<Integer>>();
        permute(num,0,resArrayListArrayList);
        return resArrayListArrayList;

    }
    public void permute(int[] num,int start,ArrayList<ArrayList<Integer>> result){
        if (start>=num.length){
            ArrayList<Integer> item=convertArrayToList(num);
            result.add(item);
        }
        for (int j=start;j<=num.length-1;j++){
            swap(num,start,j);
            permute(num,start+1,result);
            swap(num,start,j);
        }
    }
    private ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> item = new ArrayList<Integer>();
        for (int h = 0; h < num.length; h++) {
            item.add(num[h]);
        }
        return item;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args){
        PermutationsThree permutations=new PermutationsThree();
        int[] nums={1,2,3};
        System.out.println(permutations.permute(nums));
    }
}
