package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentsThiefs {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generating(n,n,"",res);
        return res;
    }

    private void generating(int left, int right, String str, List<String> res) {

        if(left == 0 && right == 0){
            res.add(str);
        }
        if(left > 0){
            generating(left-1,right,str+"(",res);
        }
        if(left<right){
            generating(left,right-1,str+")",res);
        }
    }

    public static void main(String[] args){
        GenerateParentsThiefs sol = new GenerateParentsThiefs();
        System.out.println(sol.generateParenthesis(3));
    }
}
