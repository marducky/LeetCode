package algorithm;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m==1&&n==1)
            return 1;
        if (m*n==2)
            return 1;
        int proRes=1;
        for ( int i=1;i<m;i++){
            proRes*=i;
        }
//        System.out.println(proRes);
        int proResTwo=1;
        for (int i=m+n-2;i>=n-1;i--){
            proResTwo*=i;
//            System.out.println(i);
        }
//        System.out.println(proResTwo);
        return proResTwo/proRes;

    }
    public static void main(String[] args){
        UniquePaths uniquePaths=new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(6,7));
    }

}
