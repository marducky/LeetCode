package knowledge.multiProcess.chapter3;

import java.util.ArrayList;
import java.util.List;

public class TwoThreadTransDataMain {
//    private List list=new ArrayList();
//    public void add(){
//        list.add("This a boring and tired day.");
//    }
//    public int size(){
//        return list.size();
//    }
////    public int getVale(){
////        return this.list.size();
////    }
    public static void main(String[] args){
        TwoThreadTransData twoThreadTransData=new TwoThreadTransData();
        TwoThreadTransDataOne twoThreadTransDataOne=new TwoThreadTransDataOne(twoThreadTransData);
        twoThreadTransDataOne.setName("A");
        twoThreadTransDataOne.start();
        TwoThreadTransDataTwo twoThreadTransDataTwo=new TwoThreadTransDataTwo(twoThreadTransData);
        twoThreadTransDataTwo.setName("B");
        twoThreadTransDataTwo.start();
    }
}
