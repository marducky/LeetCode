package knowledge.multiProcess.chapter3;

import java.util.ArrayList;
import java.util.List;

public class TwoThreadTransData {
    private List list=new ArrayList();
    public void add(){
        list.add("This a boring and tired day.");
    }
    public int size(){
        return list.size();
    }
//    public int getVale(){
//        return this.list.size();
//    }
}
