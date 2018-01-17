package knowledge.baseKnowledge.jsonDemo;

import java.util.List;

public class NlusDemo {
    private String name;
    private List<NluGroupDemo> nluGroupDempList;
    private List<NlusDemo> nlusDemoList;
    private List<NluDemo> nluDemoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NluGroupDemo> getNluGroupDempList() {
        return nluGroupDempList;
    }

    public void setNluGroupDempList(List<NluGroupDemo> nluGroupDempList) {
        this.nluGroupDempList = nluGroupDempList;
    }

    public List<NlusDemo> getNlusDemoList() {
        return nlusDemoList;
    }

    public void setNlusDemoList(List<NlusDemo> nlusDemoList) {
        this.nlusDemoList = nlusDemoList;
    }

    public List<NluDemo> getNluDemoList() {
        return nluDemoList;
    }

    public void setNluDemoList(List<NluDemo> nluDemoList) {
        this.nluDemoList = nluDemoList;
    }
}
