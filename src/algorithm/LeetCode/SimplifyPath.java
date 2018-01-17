/**
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
package algorithm.LeetCode;

public class SimplifyPath {
    public String simplifyPath(String path) {
//        StringBuilder resString=new StringBuilder();
        String resString="";
        int paLen=path.length();
        for (int i=paLen-2;i>=0;i--){
            if (path.charAt(i)=='/'){
//                resString.append(path.substring(i+1,paLen-2));
                resString  =path.substring(i,paLen-1);
            break;}
        }
        return resString;
    }
    public static void main(String[] args){
        SimplifyPath simplifyPath=new SimplifyPath();
        String giveString="/home/";
        String giveString1="/a/./b/../../c/";
        System.out.print(simplifyPath.simplifyPath(giveString1));
    }
}
