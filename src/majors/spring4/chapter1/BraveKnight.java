package majors.spring4.chapter1;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/19 14:52
 **/
public class BraveKnight implements Knights {
    private Quest quest;

    //    private Minstrel minstrel;
    public BraveKnight(Quest quest) {
        this.quest = quest;
//        this.minstrel=minstrel;
    }

    public void embarkOnQuest() {
//        minstrel.singBeforeQuest();
        quest.embark();
//        minstrel.singAfterQuest();
    }

//    public static void main(String[] args) {
//        BraveKnight braveKnight=new BraveKnight(new RescueDamselQuest(),new Minstrel(System.out));
//        braveKnight.embarkOnQuest();
////        BraveKnight braveKnight1=new BraveKnight(new SlayDragonQuest());
////        braveKnight1.embarkOnQuest();
//    }
}
