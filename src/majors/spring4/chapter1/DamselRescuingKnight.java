package majors.spring4.chapter1;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/19 14:46
 **/
public class DamselRescuingKnight implements Knights {
    private RescueDamselQuest quest;

    public void embarkOnQuest() {
        quest.embark();
    }

    public DamselRescuingKnight() {
        this.quest = new RescueDamselQuest();
    }
}
