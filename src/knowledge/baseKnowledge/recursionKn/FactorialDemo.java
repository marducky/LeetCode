/**
 * 对于一个复杂的问题，把原问题分解为若干个相对简单类同的子问题，继续下去直到子问题简单到能够直接求解，也就是说到了递推的出口，这样原问题就有递推得解。
 关键要抓住的是：
 （1）递归出口
 （2）地推逐步向出口逼近
 */
package knowledge.baseKnowledge.recursionKn;

public class FactorialDemo {
    public static int factorialdemo(int n){
        if(n==1||n==0){
            return n;
        }
        else {
//            System.out.println("run the "+n+" times");
        return n*factorialdemo(n-1);}
    }
    public static int countSum(int n){
        if (n>0)
            return n+countSum(n-1);
        else return 0;
    }
    public static int countCountSum(int n){
        if (n==1||n==2){
            return 1;
        }
        return countCountSum(n-1)+countCountSum(n-2);
    }
    public static void main(String[] args){
        System.out.println(factorialdemo(5));
        System.out.println(countSum(5));
        System.out.println(countCountSum(30));
    }

}
