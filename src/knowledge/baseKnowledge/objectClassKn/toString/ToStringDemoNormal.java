package knowledge.baseKnowledge.objectClassKn.toString;

import org.python.antlr.ast.Str;

public class ToStringDemoNormal {
    private String name;
    private int age;
    ToStringDemoNormal(String name,int age){
        this.age=age;
        this.name=name;
    }
    ToStringDemoNormal(){};
    @Override
    public String toString(){
        if (this.name==null){
            return "Null";
        }
        else return name+": "+age;
    }
}
