//import java.util.Scanner;
//
//public class Main {
//    public static int firstProblemSolution(String source, String target) {
//
//        if(source == null || target == null) return -1;
//
//        int i,j;
//        for(i = 0; i<source.length()-target.length()+1; i++){
//            for(j = 0; j<target.length();j++){
//                if(source.charAt(i+j)!=target.charAt(j)){
//                    break;
//                }
//            }
//            if(j==target.length()){
//                return i;
//            }
//
//        }
//
//        return -1;
//    }
//    public static void main(String[] args){
//        Scanner demoSourceTarget=new Scanner(System.in);
//        String sourceTarget=demoSourceTarget.nextLine();
//        String[] ss=new String[2];
////        System.out.println(sourceTarget);
//        ss=sourceTarget.split(" ");
//        String source=ss[0];
//        String target=ss[1];
//        int i=firstProblemSolution(source,target);
//        System.out.print(i);
//    }
//
//}

