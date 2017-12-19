/**
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
package algorithm;

public class SimplifyPathTwo {
    public String simplifyPath(String path) {
//        if (path.equals("/"))
//            return "/";
//        StringBuilder resString=new StringBuilder();
        String resString="";
        String[] steRes=path.split("/|\\.");
        if (steRes.length==0)
            return "/";
        return '/'+steRes[steRes.length-1];
    }
    public static void main(String[] args){
        SimplifyPathTwo simplifyPath=new SimplifyPathTwo();
        String giveString="/home/";
        String giveString1="/a/./b/../../c/";
        String giveString2="///";
        String giveString3="/////////.........";
        System.out.print(simplifyPath.simplifyPath(giveString3));
    }
}
