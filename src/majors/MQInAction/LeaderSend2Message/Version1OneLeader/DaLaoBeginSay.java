package majors.MQInAction.LeaderSend2Message.Version1OneLeader;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/28 11:41
 **/
public class DaLaoBeginSay {
    public static void main(String[] args) {
        DaLao daLao = new DaLao("Bill");
        XiaoDi xiaoDi1 = new XiaoDi("Neng.Qi");
        XiaoDi xiaoDi2 = new XiaoDi("ZhongHao.Han");
        XiaoDi xiaoDi3 = new XiaoDi("Xin.Fang");
        daLao.addXiami(xiaoDi1);
        daLao.addXiami(xiaoDi2);
        daLao.addXiami(xiaoDi3);
        daLao.setMessage("散会！去吃饭 ");
    }
}
