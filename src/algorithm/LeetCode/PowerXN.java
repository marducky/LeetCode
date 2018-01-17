/**
 * Example 1:

 Input: 2.00000, 10
 Output: 1024.00000
 Example 2:

 Input: 2.10000, 3
 Output: 9.26100
 */
package algorithm.LeetCode;

public class PowerXN {
    double giveDouble=2.00000;
    int allDouble=pointSum(giveDouble);
    public double myPow(double x, int n) {
        double resDou=1;
        for (int i=1;i<=n;i++){
            resDou=resDou*x;
        }
        if (pointSum(resDou)!=pointSum(x)){
            if (pointSum(resDou)>pointSum(x)){
                String tempStr=(resDou+"").substring(0,(resDou+"").length()-(pointSum(resDou)-pointSum(x)));
                return Double.valueOf(tempStr);
            }else {
                String temStrDou=resDou+"";
                for (int i=0;i<pointSum(x)-pointSum(resDou);i++){
                    temStrDou+="0";
                }
                return Double.valueOf(temStrDou);
            }
        }
        return resDou;
    }
    public int pointSum(double giveDouble){
        String temStr=giveDouble+"";
//        return temStr.split(".")[0].length();
        return temStr.substring(temStr.indexOf('.'),temStr.length()).length();
    }
    public static void main(String[] args){

        PowerXN powerXN=new PowerXN();
        System.out.print(powerXN.myPow(powerXN.giveDouble,10));
    }
}
