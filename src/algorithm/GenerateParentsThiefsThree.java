package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentsThiefsThree {
        int n=0;
    public List<String> generateParenthesis(int n) {
        List<String> stringList=new ArrayList<String>();
        gegeParete(n,n,"",stringList);
        return stringList;

    }
    public void gegeParete(int left,int right,String ssRes,List<String> res){
        if (left==0&&right==0) {
            res.add(ssRes);
            n++;
        }
        if (left>0)
            gegeParete(left-1,right,ssRes+'(',res);
        if (left<right)
            gegeParete(left,right-1,ssRes+')',res);
    }
    public static void main(String[] args){
        GenerateParentsThiefs generateParentsThiefs=new GenerateParentsThiefs();
        System.out.println(generateParentsThiefs.generateParenthesis(4));
        System.out.println();
    }


}
