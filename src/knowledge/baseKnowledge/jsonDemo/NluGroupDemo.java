package knowledge.baseKnowledge.jsonDemo;

import java.util.List;

public class NluGroupDemo {
    private List<NluDemo> nluDemos;
    private String type;
    private String condition_class;

    public List<NluDemo> getNluDemos() {
        return nluDemos;
    }

    public void setNluDemos(List<NluDemo> nluDemos) {
        this.nluDemos = nluDemos;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition_class() {
        return condition_class;
    }

    public void setCondition_class(String condition_class) {
        this.condition_class = condition_class;
    }
}
