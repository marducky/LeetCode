package majors.MQInAction.LeaderSend2Message.Version1OneLeader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/28 11:28
 **/
public class DaLao implements LeaderSay {
    String message;
    List<Xiami> xiamis;
    String name;

    public DaLao(String name) {
        this.name = name;
        xiamis = new ArrayList<>();
    }

    @Override
    public void addXiami(Xiami xiami) {
        xiamis.add(xiami);
    }

    @Override
    public void removeXiami(Xiami xiami) {
        if (!xiamis.isEmpty()) {
            xiamis.remove(xiami);
        }
    }

    @Override
    public void standUP() {
        for (Xiami xiami : xiamis) {
            xiami.update(message);
        }
    }


    public void setMessage(String message) {
        this.message = message;
        System.out.println(name + " 大佬开始发言：" + message);
        System.out.println("emmmmmmmmmmmmmmmmmmmmmmmmmm");
        standUP();
        System.out.println(name + ": emmmmmmmmmmmmmmmmmmmmmm");
    }
}
