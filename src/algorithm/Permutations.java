package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> resListList=new ArrayList<>();
        List<Integer> strToIntegerList=new ArrayList<Integer>();
        for (int i=0;i<nums.length;i++){
            strToIntegerList.add(nums[i]);
        }
        for (int j=0;j<strToIntegerList.size();j++){
            resListList.add(perPermute(strToIntegerList,j));
        }
        //TODO: Miss the define conditions.Will add some end conditions.
        return resListList;
    }
    public List<Integer> perPermute(List<Integer> integerList,int delLocation){
        List<Integer> resResList=new ArrayList<Integer>();
        List<Integer> listTemp=integerList;
        resResList.add(listTemp.get(delLocation));
        listTemp.remove(delLocation);
        for (int i=0;i<integerList.size()-1;i++){
            resResList.addAll(perPermute(listTemp,i));
        }

        return resResList;
    }
    public static void main(String[] args){
        Permutations permutations=new Permutations();
        int[] nums={1,2,3,4,5};
        System.out.println(permutations.permute(nums));
    }
}
