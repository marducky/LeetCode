package knowledge.baseKnowledge.keyMapKn.finalKn;
//“使用final方法的原因有两个。第一个原因是把方法锁定，以防任何继承类修改它的含义；第二个原因是效率。在早期的Java实现版本中，会将final方法转为内嵌调用。但是如果方法过于庞大，可能看不到内嵌调用带来的任何性能提升。在最近的Java版本中，不需要使用final方法进行这些优化了。“

//因此，如果只有在想明确禁止 该方法在子类中被覆盖的情况下才将方法设置为final的。

//        注：类的private方法会隐式地被指定为final方法。
class EmbellishMethodParent {
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public final void ppString() {
        System.out.println(this.string);

    }

    public void pppString() {
        System.out.println(this.string);
    }
}

public class EmbellishMethod extends EmbellishMethodParent {
    //    @Override
//    public void ppString(){
//
//    }
    @Override
    public void pppString() {
        System.out.println("Ok");
    }

    public static void main(String[] args) {
        EmbellishMethodParent embellishMethodParent = new EmbellishMethodParent();
        embellishMethodParent.ppString();
        EmbellishMethod embellishMethod = new EmbellishMethod();
        embellishMethod.pppString();
    }
}
