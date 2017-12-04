package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class GenerateParentsThiefsTwo {
    List<?>[] ans = new ArrayList<?>[100];
    boolean flag = false;
    int N = 1;
    public List<String> generateParenthesis(int n) {
        if(n <= N){
            if( n == 1 && flag == false){
                List<String> list = new ArrayList<String>();
                list.add("()");
                ans[N++] = list;
                flag = true;
                return list;
            }
            else
                return (List<String>)ans[n];
        }
        Set<String> set = new HashSet<String>();
        for(int i = 0 ; i < n ; i++){
            if(i == 0){
                for(String ss : generateParenthesis(n-1)){
                    set.add("("+ss+")");
                }
            }else{
                for(String ss : generateParenthesis(i)){
                    for(String aa : generateParenthesis(n-i)){
                        set.add(ss+aa);
                    }
                }
            }
        }
        if(N == n){
            ans[N++] = new ArrayList<String>(set);
        }
        return new ArrayList<String>(set);
    }

    public static void main(String[] args){
        GenerateParentsThiefs sol = new GenerateParentsThiefs();
        System.out.println(sol.generateParenthesis(3));
    }
}
